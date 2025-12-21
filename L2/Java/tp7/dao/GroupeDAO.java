package tp7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tp7.metier.Etudiant;
import tp7.metier.Groupe;

public class GroupeDAO extends DAO<Groupe> {
	private ResultSet rs;

	@Override
	public Groupe create(Groupe grp) {
		// creation du groupe seul
		String requete = "INSERT INTO groupe (code, formation) VALUES(?, ?)";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, grp.getCode());
			pstmt.setString(2, grp.getFormation());
			pstmt.executeUpdate();
			// ajout éventuel d'étudiants
			EtudiantDAO tableEtu = new EtudiantDAO();
			for (Etudiant etudiant : grp.getListeEtudiants()) {
				// s'il n'a pas de code, c'est qu'il n'est pas en base
				if (etudiant.getId() == 0) {
					Etudiant etuEnBase = tableEtu.create(etudiant);
					etudiant.setId(etuEnBase.getId());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grp;
	}

	@Override
	public Groupe update(Groupe grp) {
		String requete = "UPDATE groupe SET formation = ? WHERE code = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, grp.getFormation());
			pstmt.setString(2, grp.getCode());
			pstmt.executeUpdate();
			// ajout éventuel d'étudiants
			EtudiantDAO tableEtu = new EtudiantDAO();
			for (Etudiant etudiant : grp.getListeEtudiants()) {
				// s'il n'a pas de code, c'est qu'il n'est pas en base
				if (etudiant.getId() == 0) {
					Etudiant etuEnBase = tableEtu.create(etudiant);
					etudiant.setId(etuEnBase.getId());
				}
				// sinon update en cas de changements
				else {
					tableEtu.update(etudiant);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grp;
	}

	@Override
	public void delete(Groupe grp) {
		String requete = "DELETE FROM groupe WHERE code = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, grp.getCode());
			pstmt.executeUpdate();
			// suppression des étudiants liés
			EtudiantDAO tableEtu = new EtudiantDAO();
			for (Etudiant etudiant : grp.getListeEtudiants()) {
				// s'il a un code, c'est qu'il est en base
				if (etudiant.getId() != 0) {
					tableEtu.delete(etudiant);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Groupe read(String code) {
		Groupe grp = null;
		String requete = "SELECT code as idgrp, formation, id as idetu, prenom, nom "
			+ "FROM groupe INNER JOIN etudiant ON groupe.code = etudiant.groupecode "
			+ "WHERE code = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(
				requete, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			// chargement des étudiants liés
			if (rs.first()) {
				EtudiantDAO tableEtu = new EtudiantDAO();
				ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
				grp = new Groupe(rs.getString("idgrp"), rs.getString("formation"), listeEtudiants);
				rs.beforeFirst();
				while (rs.next()) {
					Etudiant etu = tableEtu.read(rs.getLong("idetu"));
					etu.setGroupe(grp);
					listeEtudiants.add(etu);
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return grp;
	}
	/*
	public ArrayList<Groupe> read() {
		boolean trouve = false;
		String requete = "SELECT code, formation FROM groupe ";
		ArrayList<Groupe> lesGroupes = new ArrayList<Groupe>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				Groupe grp = new Groupe(rs.getString(1), rs.getString(2));
				lesGroupes.add(grp);
				trouve = true;
			}
			rs.close();
			if (!trouve)
				lesGroupes = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesGroupes;
	}
	*/
}

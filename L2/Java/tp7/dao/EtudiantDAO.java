package tp7.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tp7.metier.Etudiant;
import tp7.metier.Groupe;

public class EtudiantDAO extends DAO<Etudiant> {
	private ResultSet rs;

	@Override
	public Etudiant create(Etudiant unEtudiant) {
		String requete = "INSERT INTO etudiant  (nom, prenom, groupecode) "
			+ "VALUES('" + unEtudiant.getNom() + "', '" + unEtudiant.getPrenom() + "', '"
			+ unEtudiant.getGroupe().getCode() + "')";
		try {
			stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
			// Les cles auto-generees sont retournees sous forme de ResultSet
			ResultSet cles = stmt.getGeneratedKeys();
			if (cles.next()) {
				long id = ((BigInteger) cles.getObject(1)).longValue();
				unEtudiant.setId(id);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unEtudiant;
	}

	@Override
	public Etudiant update(Etudiant unEtudiant) {
		// TODO Auto-generated method stub
		String requete = "UPDATE etudiant  SET nom ='" + unEtudiant.getNom() + "', ";
		requete += "prenom= '" + unEtudiant.getPrenom() + "', ";
		requete += "groupecode= '" + unEtudiant.getGroupe().getCode() + "' ";
		requete += "WHERE id = " + unEtudiant.getId();
		try {
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unEtudiant;
	}

	@Override
	public void delete(Etudiant unEtudiant) {
		// TODO Auto-generated method stub
		String requete = "DELETE FROM etudiant WHERE id = " + unEtudiant.getId();
		try {
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Etudiant read(long id) {
		GroupeDAO gd = new GroupeDAO();
		Groupe g = null;
		Etudiant et = null;
		String requete = "SELECT id, nom, prenom, groupecode FROM etudiant WHERE id = " + id;
		try {
			rs = stmt.executeQuery(requete);
			if (rs.first()) {
				// Commented to prevent infinite recursion (Etudiant -> Groupe -> Etudiant -> ...)
				// g = gd.read(rs.getString(4));
				et = new Etudiant(rs.getLong(1), rs.getString(2), rs.getString(3), g);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return et;
	}

	public ArrayList<Etudiant> read() {
		GroupeDAO gd = new GroupeDAO();
		Groupe g = null;
		boolean trouve = false;
		String requete = "SELECT id, nom, prenom, codegroupe FROM etudiant ";
		ArrayList<Etudiant> lesEtudiants = new ArrayList<Etudiant>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				g = gd.read(rs.getString(4));
				Etudiant et = new Etudiant(rs.getLong(1), rs.getString(2), rs.getString(3), g);
				lesEtudiants.add(et);
				trouve = true;
			}
			rs.close();
			if (!trouve)
				lesEtudiants = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesEtudiants;
	}

	public ArrayList<Etudiant> readGroupe(long codeGroupe) {
		GroupeDAO gd = new GroupeDAO();
		Groupe g = null;
		boolean trouve = false;
		String requete =
			"SELECT id, nom, prenom, codegroupe FROM etudiant WHERE codegroupe = " + codeGroupe;
		ArrayList<Etudiant> lesEtudiants = new ArrayList<Etudiant>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				g = gd.read(rs.getString(4));
				Etudiant et = new Etudiant(rs.getLong(1), rs.getString(2), rs.getString(3), g);
				lesEtudiants.add(et);
				trouve = true;
			}
			rs.close();
			if (!trouve)
				lesEtudiants = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesEtudiants;
	}
}

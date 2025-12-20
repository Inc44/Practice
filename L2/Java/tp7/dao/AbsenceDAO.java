package tp7.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp7.metier.Absence;
import tp7.metier.Etudiant;

public class AbsenceDAO extends DAO<Absence> {
	private ResultSet rs;

	@Override
	public Absence create(Absence abs) {
		// TODO Auto-generated method stub

		String requete = "INSERT INTO absence (dateabs, hrabs, groupecode, etudiantid) ";
		requete = requete + "VALUES('" + abs.getDateAbs() + "' ,'" + abs.getHrAbs() + "', "
			+ abs.getEtudiant().getId() + ")";
		try {
			// stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abs;
	}

	@Override
	public Absence update(Absence abs) {
		// Can't, as every column is a primary key
		return abs;
	}

	@Override
	public void delete(Absence abs) {
		// TODO Auto-generated method stub
		String requete = "DELETE FROM absence";
		requete += " WHERE dateabs = '" + abs.getDateAbs() + "', ";
		requete += "AND hrabs = '" + abs.getHrAbs() + "', ";
		requete += "AND etudiantid = " + abs.getEtudiant().getId();
		try {
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String date, String heure) {
		String requete = "DELETE FROM absence";
		requete = requete + " WHERE dateabs = '" + date + "' ";
		requete = requete + "AND hrabs = '" + heure + "'";
		try {
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Etudiant etudiant) {
		String requete = "DELETE FROM absence";
		requete = requete + " WHERE etudiantid = " + etudiant.getId();
		try {
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Absence> read() {
		EtudiantDAO etDAO = new EtudiantDAO();
		Etudiant et = null;
		boolean trouve = false;
		String requete = "SELECT dateabs, hrabs, etudiantid FROM absence";
		ArrayList<Absence> lesAbsences = new ArrayList<Absence>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				et = etDAO.read(rs.getLong(3));
				Absence abs = new Absence(rs.getString(1), rs.getString(2), et);
				lesAbsences.add(abs);
				trouve = true;
			}
			rs.close();
			if (!trouve)
				lesAbsences = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesAbsences;
	}

	public ArrayList<Absence> read(String date, String heure) {
		EtudiantDAO etDAO = new EtudiantDAO();
		Etudiant et = null;
		boolean trouve = false;
		String requete = "SELECT dateabs, hrabs, etudiantid FROM absence";
		requete = requete + " WHERE dateabs = '" + date + "', ";
		requete = requete + "AND hrabs = '" + heure + "'";

		ArrayList<Absence> lesAbsences = new ArrayList<Absence>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				et = etDAO.read(rs.getLong(3));
				Absence abs = new Absence(rs.getString(1), rs.getString(2), et);
				lesAbsences.add(abs);
				trouve = true;
			}
			rs.close();
			if (!trouve)
				lesAbsences = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesAbsences;
	}
}

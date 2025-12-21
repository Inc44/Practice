package tp7.dao;

import java.sql.PreparedStatement;
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

		String requete = "INSERT INTO absence (dtabs, hrabs, etudiantid) VALUES(?, ?, ?)";
		try {
			// PreparedStatement pstmt = connect.prepareStatement(requete,
			// Statement.RETURN_GENERATED_KEYS);
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, abs.getDateAbs());
			pstmt.setString(2, abs.getHrAbs());
			pstmt.setInt(3, abs.getEtudiant().getId());
			pstmt.executeUpdate();
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
		String requete = "DELETE FROM absence WHERE dtabs = ? AND hrabs = ? AND etudiantid = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, abs.getDateAbs());
			pstmt.setString(2, abs.getHrAbs());
			pstmt.setInt(3, abs.getEtudiant().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String date, String heure) {
		String requete = "DELETE FROM absence WHERE dtabs = ? AND hrabs = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, date);
			pstmt.setString(2, heure);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Etudiant etudiant) {
		String requete = "DELETE FROM absence WHERE etudiantid = ?";
		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setInt(1, etudiant.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Absence> read() {
		EtudiantDAO etDAO = new EtudiantDAO();
		Etudiant et = null;
		boolean trouve = false;
		String requete = "SELECT dtabs, hrabs, etudiantid FROM absence";
		ArrayList<Absence> lesAbsences = new ArrayList<Absence>();

		try {
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				et = etDAO.read(rs.getInt(3));
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
		String requete =
			"SELECT dtabs, hrabs, etudiantid FROM absence WHERE dtabs = ? AND hrabs = ?";

		ArrayList<Absence> lesAbsences = new ArrayList<Absence>();

		try {
			PreparedStatement pstmt = connect.prepareStatement(requete);
			pstmt.setString(1, date);
			pstmt.setString(2, heure);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				et = etDAO.read(rs.getInt(3));
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

package tp7.test;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Test1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String databaseName = "absences";
		// Parametres de connexion : url, login, mdp
		// Port mysql avec USBWebserver:3307, xampp: 3306
		String url = "jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=UTC";
		String login =
			"root"; // dans l'idal un login de connexion pour l'application, et non root...
		String password = ""; // mot de passe avec xampp
		// String password = "usbw"; // mot de passe root avec USBWebServer

		Connection cn = null;
		/*
		// Creation d'une connexion avec DriverManager
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver OK !");
			cn = DriverManager.getConnection(url, login, password);
			System.out.println("Connexion réussie !");
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur de chargement du driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur d'établissement de connexion");
			e.printStackTrace();
		}
		*/
		// Creation d'une connexion avec MysqlDataSource
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(url);
		mysqlDS.setUser(login);
		mysqlDS.setPassword(password);

		try {
			cn = mysqlDS.getConnection();
		} catch (SQLException e1) {
			System.err.println("Erreur de parcours de connexion");
			e1.printStackTrace();
		}

		/*
		// Execution d'une requete test
		// Execution de requetes
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sqlQuery = "SELECT * FROM etudiant";
			st = cn.prepareStatement(sqlQuery);
			rs = st.executeQuery();
		} catch (SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}

		// Affichage du resultat
		try {
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String code = rs.getString("groupecode");
				System.out.println("Etudiant : " + nom + " " + prenom + ", groupe : " + code);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		*/

		/*
		// 6) a)
		System.out.println("\n Etudiants du groupe INFL2G1A");
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sqlQuery = "SELECT * FROM etudiant WHERE groupecode LIKE ?";
			st = cn.prepareStatement(sqlQuery);
			st.setString(1, "INFL2G1A");
			rs = st.executeQuery(); // utiliser executeQuery quand on fait un select
									// (executeQuery retourne un objet Result)
		} catch (SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}

		// Affichage du resultat
		try {
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String code = rs.getString("groupecode");
				System.out.println("Etudiant : " + nom + " " + prenom + ", groupe : " + code);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		*/

		/*
		// 6) b)
		PreparedStatement st = null;
		try {
			String sqlQuery = "INSERT INTO etudiant (nom, prenom, groupecode)"
				+ "VALUES (?, ?, ?)";
			st = cn.prepareStatement(sqlQuery);
			st.setString(1, "MELON");
			st.setString(2, "Gilles");
			st.setString(3, "INFL2G1A");
			int result = st.executeUpdate(); // utiliser executeUpdate
			// quand on fait autre chose qu'un select (executeUpdate retourne un int du nombre de
			// modifications)
			System.out.println("\n Nombre d'ajouts : " + result);

		} catch (SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
		*/

		/*
		// 6) c)
		PreparedStatement st = null;
		try {
			String sqlQuery = "DELETE FROM etudiant WHERE nom LIKE ? AND prenom LIKE ?";
			st = cn.prepareStatement(sqlQuery);
			st.setString(1, "MELON");
			st.setString(2, "Gilles");
			int result = st.executeUpdate();
			System.out.println("\n Nombre de suppressions : " + result);

		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}
		*/

		/*
		// 6) d)
		PreparedStatement st = null;
		try {
			String sqlQuery = "UPDATE etudiant SET nom=? WHERE nom LIKE ?";
			st = cn.prepareStatement(sqlQuery);
			st.setString(1, "MARTIN");
			st.setString(2, "SENAI");
			int result = st.executeUpdate();
			System.out.println("\n Nombre de modifications : " + result);

		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}
		*/

		/*
		// 6) e)
		ResultSet rs = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Entrez le nom (ex. : DIEUDONNE ou SENOUN) : ");
			String nom = sc.nextLine();
			System.out.print("Entrez le prenom (ex. : CLAIRE ou KARIM) : ");
			String prenom = sc.nextLine();
			sc.close();
			String sqlQuery = "SELECT * FROM etudiant WHERE nom LIKE ? AND prenom LIKE ?";
			PreparedStatement pstmt = cn.prepareStatement(sqlQuery);
			pstmt.setString(1, nom);
			pstmt.setString(2, prenom);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}

		// Affichage du resultat
		try {
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String code = rs.getString("groupecode");
				System.out.println("Etudiant : " + nom + " " + prenom + ", groupe : " + code);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de parcours de ResultSet");
			e.printStackTrace();
		}
		*/

		/*
		// 6) f)
		Statement st = null;
		try {
			st = cn.createStatement();
			String sqlQuery = "CREATE TABLE IF NOT EXISTS discipline ("
				+ "dispilineId INT PRIMARY KEY,"
				+ "libelle VARCHAR(100))";
			st.executeUpdate(sqlQuery);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		*/

		// 6) g)
		PreparedStatement st = null;
		try {
			cn.setAutoCommit(false);
			String sqlQuery = "INSERT INTO discipline VALUES(?, ?) "
				+ "ON DUPLICATE KEY UPDATE libelle=?";
			PreparedStatement stmt = cn.prepareStatement(sqlQuery);
			stmt.setInt(1, 1);
			stmt.setString(2, "Informatique");
			stmt.setString(3, "Informatique");
			stmt.addBatch();
			stmt.setInt(1, 2);
			stmt.setString(2, "Biologie");
			stmt.setString(3, "Biologie");
			stmt.addBatch();
			stmt.setInt(1, 3);
			stmt.setString(2, "Mathématique");
			stmt.setString(3, "Mathématique");
			stmt.addBatch();
			int[] updateCounts = stmt.executeBatch();
			cn.commit();
			cn.setAutoCommit(true);
			stmt.clearBatch();

		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}
	}
}

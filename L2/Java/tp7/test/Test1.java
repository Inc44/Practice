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
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cn.createStatement();
			String sqlQuery = "SELECT * FROM etudiant";
			rs = st.executeQuery(sqlQuery);
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
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cn.createStatement();
			String sqlQuery = "SELECT * FROM etudiant WHERE groupecode LIKE 'INFL2G1A'";
			rs = st.executeQuery(sqlQuery); // utiliser executeQuery quand on fait un select
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
		Statement st = null;
		try {
			st = cn.createStatement();
			String sqlQuery = "INSERT INTO etudiant (nom, prenom, groupecode)"
				+ "VALUES ('MELON', 'Gilles', 'INFL2G1A')";
			int result = st.executeUpdate(sqlQuery); // utiliser executeUpdate
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
		Statement st = null;
		try {
			st = cn.createStatement();
			String sqlQuery =
				"DELETE FROM etudiant WHERE nom LIKE 'MELON' AND prenom LIKE 'Gilles'";
			int result = st.executeUpdate(sqlQuery);
			System.out.println("\n Nombre de suppressions : " + result);

		} catch (SQLException e) {
			System.err.println("Erreur requête SQL");
			e.printStackTrace();
		}
		*/

		/*
		// 6) d)
		Statement st = null;
		try {
			st = cn.createStatement();
			String sqlQuery = "UPDATE etudiant SET nom='MARTIN' WHERE nom LIKE 'SENAI'";
			int result = st.executeUpdate(sqlQuery);
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
		Statement st = null;
		try {
			cn.setAutoCommit(false);
			Statement stmt = cn.createStatement();
			stmt.addBatch("INSERT INTO discipline "
				+ "VALUES(1, 'Informatique')"
				+ "ON DUPLICATE KEY UPDATE libelle='Informatique'");
			stmt.addBatch("INSERT INTO discipline "
				+ "VALUES(2, 'Biologie')"
				+ "ON DUPLICATE KEY UPDATE libelle='Biologie'");
			stmt.addBatch("INSERT INTO discipline "
				+ "VALUES(3, 'Mathématique')"
				+ "ON DUPLICATE KEY UPDATE libelle='Mathématique'");
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

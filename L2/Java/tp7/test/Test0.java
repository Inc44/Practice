package tp7.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Test0 {
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
			System.out.println("Connexion reussie !");
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur de chargement du driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur d'etablissement de connexion");
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
	}
}

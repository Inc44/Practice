package tp7.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DAO<T> {
	protected Connection connect;
	protected Statement stmt;

	public DAO() {
		open();
	}

	public void open() {
		try {
			connect = SingleConnection.getInstance();
			stmt = connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" === ERREUR OPEN DAO === ");
			e.printStackTrace();
		}
	}

	public void close() {
		// on ferme l'acces a la BDD
		try {
			SingleConnection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" === ERREUR CLOSE DAO === ");
			e.printStackTrace();
		}
	}

	/**
	 * Permet de recuperer les objets
	 * @param
	 * @return
	 */
	//	public abstract ArrayList <T> read();

	/**
	 * Permet de creer une entree dans la base de donnees
	 * par rapport a un objet
	 * @param obj
	 */
	public abstract T create(T obj);

	/**
	 * Permet de mettre a jour les donnees d'une entree dans la base
	 * @param obj
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entree de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}

package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	private static String DB_URL;
	private static String DB_LOGIN;
	private static String DB_PWD;

	public static void main(String[] args) throws SQLException {

//		Connection à la BDD
		ResourceBundle props = ResourceBundle.getBundle("database");
		DB_URL = props.getString("jdbc.url");
		DB_LOGIN = props.getString("jdbc.login");
		DB_PWD = props.getString("jdbc.pwd");
		Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
		System.out.println(connection);

		Statement selectFournisseur = connection.createStatement();
		ResultSet curseur = selectFournisseur.executeQuery("SELECT * FROM FOURNISSEUR");

		ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
		while (curseur.next()) {
			Integer id = curseur.getInt("ID");
			String nom = curseur.getString("NOM");
			Fournisseur fournisseur = new Fournisseur(id, nom);
			fournisseurs.add(fournisseur);
			System.out.println(fournisseurs);
		}
		
		selectFournisseur.close();
		curseur.close();
	}
}
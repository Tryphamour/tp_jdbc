package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	private static String DB_URL;
	private static String DB_LOGIN;
	private static String DB_PWD;

	public static void main(String[] args) throws SQLException {

//		Connection ? la BDD
		ResourceBundle props = ResourceBundle.getBundle("database");
		DB_URL = props.getString("jdbc.url");
		DB_LOGIN = props.getString("jdbc.login");
		DB_PWD = props.getString("jdbc.pwd");
		Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
		System.out.println(connection);
		
//		SUPPRIMER UN FOURNISSEUR
		Statement supprFournisseur = connection.createStatement();
		int nb = supprFournisseur.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM='La Maison des Peintures'");

		supprFournisseur.close();
		connection.close();
	}
}
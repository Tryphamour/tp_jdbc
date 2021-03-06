package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

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
		
//		INSERER UN NOUVEAU FOURNISSEUR
		Statement insererFournisseur = connection.createStatement();
		int nb = insererFournisseur.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (6,'Test')");	
		
		insererFournisseur.close();
		connection.close();

	}
}
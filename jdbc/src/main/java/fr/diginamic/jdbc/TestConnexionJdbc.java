package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// CLASSE TEST CONNEXION A UNE BDD CLOUD

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException {

		ResourceBundle props = ResourceBundle.getBundle("database");
		String url = props.getString("jdbc.url");
		String login = props.getString("jdbc.login");
		String pwd = props.getString("jdbc.pwd");
		Connection connection = DriverManager.getConnection(url, login, pwd);
		System.out.println(connection);
		connection.close();
	}
}
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	
	//declared my url, username and password
	private static final String DB_URL = "url";
	private static final String DB_USERNAME = "username";
	private static final String DB_PASSWORD = "password";
	
	public static void main(String[] args) {
		
		//used my previously declared url, username and password to create a connection
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			
			//we create statements to access to our databases. it is good when we are using static sql statements. remember, statement interface don't accept parameters like prepared statements.
			try (Statement statement = connection.createStatement()) {
				//executing the query to get the resultset of every data from my database
				try (ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {
					while (resultSet.next()) {
						int id = resultSet.getInt(1);
						String firstName = resultSet.getString(2);
						String lastName = resultSet.getString(3);
						
						
						System.out.print(id + ") ");
						System.out.print(firstName + " ");
						System.out.println(lastName);
						
						System.out.println("-----------------");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

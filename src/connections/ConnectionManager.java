package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sys";	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// method for creating connection
		public static Connection getConnection() {
			
			Connection conn = null;
			
			try {
				//Guarantees that the driver gets loaded in before we establish the connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//project should have driver loaded in (mysql driver we have from the jar)
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);			
				System.out.println("Connected.");
				 
			} catch(SQLException e) {
				System.out.println("Could not make connection.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
		
		// main is only here so we can test our method above
		public static void main(String[] args) {
			Connection conn = ConnectionManager.getConnection();
			
			try {
				conn.close();
				System.out.println("Connection closed."); 
				
			} catch(SQLException e) {
				System.out.println("Could not close connection.");
			}
		} 		
	
}

package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/progresstracker";	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);			
		} catch(SQLException e) {
			System.out.println("Could not make connection.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
		
		// main is only here so we can test our method above
//		public static void main(String[] args) {
//			Connection conn = ConnectionManager.getConnection();
//			
//			try {
//				conn.close();
//				System.out.println("Connection closed."); 
//				
//			} catch(SQLException e) {
//				System.out.println("Could not close connection.");
//			}
//		} 		
	
}

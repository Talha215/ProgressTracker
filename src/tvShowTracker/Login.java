package tvShowTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connections.ConnectionManager;

public class Login {
	public Login() {
		System.out.println("Error");
	}
	
	public Login(String username, String password) {
		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username, password FROM users");
			
			System.out.println("Users:");
			while(rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
			}
			
		} catch(SQLException e) {
			System.out.println("Could not make connection.");
		}
	}
}

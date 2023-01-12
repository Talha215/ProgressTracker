package tvShowTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connections.ConnectionManager;

public class Login {
	public static int ID = -1;
	
	public Login() {
		System.out.println("Error");
	}
	
	public Login(String username, String password) {
		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT login_id, user_name, passcode FROM login");
			
			while(rs.next()) {
				String id = rs.getString("login_id");
				String user = rs.getString("user_name");
				String pass = rs.getString("passcode");
				
				if(user.equals(username) && pass.equals(password))
					ID = Integer.parseInt(id);
			}
			
		} catch(SQLException e) {
			System.out.println("Could not make connection.");
		}
	}
	
	
}

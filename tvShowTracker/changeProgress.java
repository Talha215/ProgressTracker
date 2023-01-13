package tvShowTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connections.ConnectionManager;

public class changeProgress {
	
	public static void main(String[] args) {
		change();
	}
	
	public static void change() {
		
		System.out.println("Which entry do you want to update?");
		
		//List out all the show they have currently added and their progress FOR THE APPROPIATE USER
		
			try (Connection conn = ConnectionManager.getConnection()) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE login_id = 1");
				
				while(rs.next()) {
					String id = rs.getString("users_id");
					String login = rs.getString("login_id");
					String showname = rs.getString("show_name");
					String status = rs.getString("show_status");
					
					System.out.println("SHOW ID: " + id + " | " + showname + " | Status = " + status);
				}
				
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the user SHOW ID: ");
				int theID = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter the current status: ");
				String update = input.nextLine();
				
				
				PreparedStatement pstmt = conn.prepareStatement("update users set show_status = ? where users_id = ?");
				pstmt.setString(1, update);
				pstmt.setInt(2, theID);
							
				int run = pstmt.executeUpdate();
				
				
//				int update = stmt.executeUpdate("update users set show_status = \"not completed\" where users_id = 1");
//				System.out.println("Row Updated");
//				\"in-progress\"

				
				input.close();
				
			} catch(SQLException e) {
				System.out.println("Could not make connection.");
			}
		}
		
	}



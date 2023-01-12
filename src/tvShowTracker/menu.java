package tvShowTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connections.ConnectionManager;

public class menu {
	private static int userID;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Login:");
		
		System.out.print("username: ");
		String username = input.nextLine();
		
		System.out.print("password: ");
		String password = input.nextLine();
		
		Login user = new Login(username, password);
		if(user.ID < 0) {
			System.out.println("Login not found.");
			input.close();
			return;
		}
		
		userID = user.ID;
		
		menu();
		input.close();
	}
	
	public static void menu() {
		System.out.println("Welcome to the TV Show Data Tracker");
		System.out.println("1. Add Show");
		System.out.println("2. View Progress");
		System.out.println("3. Update Progress");
		System.out.println("4. Delete Show");
		System.out.println("5. Log Out");
		System.out.print("Enter your choice: ");
		
		Scanner sc = new Scanner(System.in);
	
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option){
			case 1:
				try {
					System.out.println("Add Show");
				}catch(Exception e) {
					System.out.println("Invalid input");
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					viewProgress();
				}catch(Exception e) {
					System.out.println("Invalid input");
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Update");
				}catch(Exception e) {
					System.out.println("Invalid Input");
					e.printStackTrace();
				}
					break;
			case 4:
				try {
					System.out.print("Enter the show ID to remove from your profile: ");
					int showID = Integer.parseInt(sc.nextLine());
					removeShow(showID);
				}catch(Exception e) {
					System.out.println("Invalid input");
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Thank you for using the tracker. Goodbye!\n\n");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice, try again.");
				menu();
		}
		sc.close();
	}
	
	
	public static void viewProgress() {
		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT tvshows_id, show_name, show_status, progress FROM users");
			
			List<String> notCompleted = new ArrayList<>();
			List<String> inProgress = new ArrayList<>();
			List<String> completed = new ArrayList<>();

			while(rs.next()) {
				String tvShowID = rs.getString("tvshows_id");
				String tvShowName = rs.getString("show_name");
				String status = rs.getString("show_status");
				int progress = rs.getInt("progress");
				
				String entry = "Tv Show - ID: " + tvShowID + ", Name: '" + tvShowName + "'," +
						(status.equals("in-progress") ? "" : (" Progress: " + progress + "%"));
				switch(status) {
				case "not completed":
					notCompleted.add(entry);
					break;
				case "in-progress":
					inProgress.add(entry);
					break;
				case "completed":
					completed.add(entry);
					break;
				}
			}
			
			System.out.println("Not Completed");
			System.out.println("-------------");
			notCompleted.forEach((entry)-> System.out.println(entry));
			
			System.out.println("\nIn Progress");
			System.out.println("-------------");
			inProgress.forEach((entry)-> System.out.println(entry));

			System.out.println("\nCompleted");
			System.out.println("-------------");
			completed.forEach((entry)-> System.out.println(entry));
			
		} catch(SQLException e) {
			System.out.println("ViewProgress: Could not make connection.");
		}
	}

	public static void removeShow(int showID) {
		try (Connection conn = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE login_id= ? and show_id= ? ");
			pstmt.setInt(1, userID);
			pstmt.setInt(2, showID);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Could not make connection.");
		}
	}
 
}

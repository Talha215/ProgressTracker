package tvShowTracker;

import java.sql.Connection;
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
		
		//input.close();
		menu();
	}
	
	public static void menu() {
		System.out.println("Welcome to the Tv show Data Tracker");
		System.out.println("\n 1.Add Show");
		System.out.println("\n 2.View Progress");
		System.out.println("\n 3.Update");

		
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
					System.out.println("View Progress");
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
			default:
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

 
}

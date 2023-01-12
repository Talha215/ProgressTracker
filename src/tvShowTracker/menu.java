package tvShowTracker;

import java.util.Scanner;

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
			return;
		}
		
		userID = user.ID;
		
		input.close();
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

 
}

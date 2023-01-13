package tvShowTracker;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Login:");
		
		System.out.print("username: ");
		String username = input.nextLine();
		
		System.out.print("password: ");
		String password = input.nextLine();
		
		if(!Functions.login(username, password)) {
			System.out.println("Login not found.");
			input.close();
			return;
		}
		
		startMenu();
		input.close();
	}
	
	public static void startMenu() {
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
		
		System.out.println();
		switch(option){
			case 1:
				System.out.println("Add Show");
				break;
			case 2:
				Functions.viewProgress();
				break;
			case 3:
				System.out.println("Update");
				break;
			case 4:
				try {
					System.out.print("Enter the show ID to remove from your profile: ");
					int showID = Integer.parseInt(sc.nextLine());
					Functions.removeShow(showID);
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
				sc.close();
				sc = null;
				System.out.println("Invalid choice, try again.");
				startMenu();
		}
		
		
		System.out.println("\n\n");
		startMenu();
		if (sc != null) {
			sc.close();
		}
	}
	
}

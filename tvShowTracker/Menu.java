package tvShowTracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Login:");

		System.out.print("username: ");
		String username = input.nextLine();

		System.out.print("password: ");
		String password = input.nextLine();

		try {
			Functions.login(username, password);
		} catch (InvalidLoginException e) {
			e.printStackTrace();
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
		int option = 5;
		
		try{
			option = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			try {
				throw new InvalidOptionException();
			} catch(InvalidOptionException e2) {
				System.out.println(e2.getMessage());
				startMenu();
				return;
			}
		}

		System.out.println();
		switch (option) {
		case 1:
			Functions.addtvshow();
			break;
		case 2:
			Functions.viewProgress();
			break;
		case 3:
			Functions.change();
			break;
		case 4: // ADD ERROR CHECKING
			Functions.display();
			System.out.print("Enter the show ID to remove from your profile: ");
			int showID = Integer.parseInt(sc.nextLine());
			Functions.removeShow(showID);
			break;
		case 5:
			System.out.println("Thank you for using the tracker. Goodbye!\n\n");
			sc.close();
			return;
		default:
			try {
				throw new InvalidOptionException();
			} catch (InvalidOptionException e3){
				System.out.println(e3.getMessage());
			} finally {
				startMenu();
			}
			return;
		}

		System.out.println("\n\n");
		startMenu();
		if (sc != null) {
			sc.close();
		}
		
		
	}

}

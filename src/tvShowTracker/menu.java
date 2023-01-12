package tvShowTracker;

import java.util.Scanner;

public class menu {
	public static void main(String[] args) {
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

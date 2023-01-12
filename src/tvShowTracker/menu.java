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
				System.out.println("Add Show");
				break;
			case 2:
				System.out.println("View Progress");
				break;
			case 3:
				System.out.println("Update");
				break;
			
			
		}
		
		sc.close();
	}

 
}

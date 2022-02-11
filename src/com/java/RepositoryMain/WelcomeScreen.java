package com.java.RepositoryMain;
import java.io.IOException;
import java.util.Scanner;

public class WelcomeScreen {
	
	public static void greetingsMsg() {
		System.out.println("--------------------------------------------------------");
		
		System.out.println("-        Welcome to File Management Application        -");
		System.out.println("-        Developed and Managed by Bablu Prasad         -");
		
		System.out.println("--------------------------------------------------------");
	}
	
	public static void welcomeMsg() {
		
		System.out.println("Main Menu:");
		System.out.println("1. Display Files in Ascending Order");
		System.out.println("2. File Operations Options");
		System.out.println("3. Exit the Application");
		System.out.println("Please enter your choice");
		WelcomeScreen.welcomeScreenInput();
	}
	
	public static void fileOperationsMenu() {
		//Option to add a user specified file to the application
		System.out.println("1.Add a new File");
		//Option to delete a user specified file from the application
		System.out.println("2.Delete a File");
		//Option to search a user specified file from the application
		System.out.println("3.Search a File");
		//Navigation option to close the current execution context and return to the main context
		System.out.println("4.Return to Main Menu");
		System.out.println("Please enter your choice");
		WelcomeScreen.fileOperationScreenInput();

	}
	public static void welcomeScreenInput() {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		switch(n) {
		case 1 : // handle display files in  ascending 
			FileHandling.displayAllFiles();
			welcomeMsg();
			break;
		case 2: // handle file operations
				WelcomeScreen.fileOperationsMenu();
			break;
			
		case 3: System.out.println("Program exited successfully.");
			//running = false;
			System.exit(0);
			//sc.close();
			break;
		default:
			System.out.println("Please select a valid Options from above");
			welcomeMsg();
		}
		
	}
public static void fileOperationScreenInput() {
		
		try {
			Scanner sc = new Scanner(System.in);
			int inp = sc.nextInt();
			
			switch(inp) {
			case 1 : // add file
				System.out.println("Enter the name of the file to be added to the \"Files\" folder");
				String fileToAdd = sc.next();
				
				FileHandling.createFile(fileToAdd);
				
				break;
			case 2: // delete file
				System.out.println("Enter the name of file to Delete from \"Files\" folder");
				String fileName = sc.next();
				FileHandling.deleteFile(fileName);
				
				break;
				
			case 3: //search file
				System.out.println("Enter the name of file to Search from \"Files\" folder");
				String filetosearchName = sc.next();
				FileHandling.searchFile(filetosearchName);
				
				break;
			case 4: // return to main menu
				WelcomeScreen.welcomeMsg();
				//sc.close();
				break;
			default:
				System.out.println("Please select a valid Options from above");
				fileOperationsMenu();
				break;
			}
		}
		catch(Exception e) {
			System.out.println("Please enter a valid input");
			fileOperationsMenu();
		}
		
	}

}

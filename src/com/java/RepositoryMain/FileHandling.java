package com.java.RepositoryMain;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileHandling {
	public static void createFilesFolder() {
		File file = new File("Files");

		//create the Files folder if already not created
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	public static void displayAllFiles() {
		FileHandling.createFilesFolder();
		File file = new File("Files");

		
		String[] filesListNames = file.list();
		List<String> filesList = Arrays.asList(filesListNames); 

		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesList);

		filesList.stream().forEach(System.out::println);
	}
	public static void createFile(String fileToAdd) {
		// create the files and prompt user for input to the file
		FileHandling.createFilesFolder();
		try {
		      File filePath = new File(".\\Files\\"+fileToAdd);
		      if (filePath.createNewFile()) {
		        System.out.println("File created: " + fileToAdd);
		      } else {
		        System.out.println("File already exists.");
		      }
		      	try {
		      		
		      		Path fileName = Path.of(
		      	            ".\\Files\\"+fileToAdd);
			      	System.out.println("\n\nInput content and press enter\n");
			      	Scanner sc = new Scanner(System.in);
					String content = sc.nextLine();
					
					Files.writeString(fileName, content);
					//sc.close();
					System.out.println("\nContent written to file " + fileToAdd);
		      	}
		      	catch(IOException e) {
		      		System.out.println("Errorrrr");
		      	}
		    } 
		
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		WelcomeScreen.fileOperationsMenu();
		
	}
	
	public static void deleteFile(String fileName) {
		File fileToDelete = new File(".\\Files\\"+fileName);
		if (fileToDelete.delete()) { 
		      System.out.println("Deleted the file: " + fileToDelete.getName()+" successfully");
		    } else {
		      System.out.println("Error 404: File Not Found.");
		    } 
		WelcomeScreen.fileOperationsMenu();
	}
	
	public static void searchFile(String filetosearchName) {
		try {
			File dir = new File(".\\Files");
		    String[] children = dir.list();
		      
		      if (children == null) {
		         System.out.println("The folder is Empty");
		      } else {
		    	  int found=0;
		         for (int i = 0; i < children.length; i++) {
		            String filename = children[i];
		            
		            if(filetosearchName.equals(filename)) {
		            	System.out.println(filename+" exists at "+ dir.getAbsoluteFile());
		            	found=1;
		            }
		         }
		         if(found==0) {
		        	 System.out.println("No such file exist in the folder. Please check the file name again");
		         }
		      }
		}
		catch(Exception e) {
			System.out.println("Error encountered while Searching.");
			e.printStackTrace();
		}
		WelcomeScreen.fileOperationsMenu();
	}
}

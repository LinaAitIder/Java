package application;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the directory path :");
		String folderPath = sc.nextLine();
		File dir = new File(folderPath);
		readFilesFolderThread a = new readFilesFolderThread(dir);
		Thread th = new Thread(a ,"Read File's Folder");
		th.start();
		// The user inserts the folder path 
		// Response all the files that exists in that folder displayed
	}

}

package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFilesFolderThread implements Runnable{
	private File directory;
	readFilesFolderThread(File directory){
		this.directory = directory;
	}
	//A function that reads the content of each file
	public void displayFileContent(File file) {
		System.out.println("File's Content------"); 
		try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line=br.readLine())!= null) {
			System.out.println(line);
		}
		System.out.println("------------------"); 
		System.out.println(" "); 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}
	@Override
	public void run() {
		//Reading the files in the dir specified
		File[] files = directory.listFiles();
		while(true) {
		for(File file : files) {
			System.out.println(file.getName());
			displayFileContent(file);
		try {
			Thread.sleep(30000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}
}

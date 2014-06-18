package taskManager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import taskManager.subject.subjectInterface;

/**
 * This class has methods that will read file line by line
 * and export it to subjectClass
 * 
 * @author Bhavin Desai, Sudeep Abhyankar 
 *
 */
public class readFile{
    subjectInterface sc;
	BufferedReader input;
	public readFile(String filename, subjectInterface sc) {
		
		try{
			this.sc = sc;
			File file = new File(filename);
			input = new  BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found!");
		}
	}
	
	
	public void readingFile(){
		try{		 
			 String line; 
			 
			 while((line=input.readLine()) !=null){
				 	
				 	sc.exportLine(line);
				 	String details[] = line.split(" ");
				 	sc.notifyObserver(details[0]);
			 }
		}
		catch(IOException e){
			System.out.println("IO exception detected!!");
		}
		catch(NullPointerException e)
		{
			System.out.println("Null Pointer Exception !!  Observers cannot be notified");
		}
	}
}


package csRegs.dataStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import csRegs.util.logger;
import csRegs.util.resultStore;


/* This is a threaded class which reads data from the search file 
 * and stores matched results into resultStore class' arraylist.
 */
public class searchFile implements Runnable {
		
	BufferedReader input;
	resultStore resSt = new resultStore();
	/*  constructor takes the filename to be read and opens it 
	 *  handling the exceptions
	 */
	public searchFile(String filename) {
		if(logger.getDebugVal()==4)
		{
			logger.dump(logger.getDebugVal(), "Inside searchFile() constructor");
		}
		try{
			File file = new File(filename);
			input = new  BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			System.out.println("Search File Not Found!");
			System.exit(0);
		}
	}
	
	// Initialize thread
	public void run(){
		if(logger.getDebugVal()==3)
		{
			logger.dump(logger.getDebugVal(), "Thread For Searching File");
		}
		readFile();
	}
	
	registrationStore rs = new registrationStore();
	comparison cmp = new comparison();
	// Our function that reads from search file 
	public synchronized void readFile(){
		
		try{
			 String strline; 
			 while((strline=input.readLine()) !=null){		 
					/* Reads each line from search file 
					 * and calls the compare method ofcomparison class
					 * to match results
					 */
					cmp.compare(strline);
			}
			
		}
		catch(IOException e){
			System.out.println("IO Exception Detected");
		}
	}
}

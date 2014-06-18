package sortedInsertVisitors.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Bhavin
 * 
 * This class helps open, read and close the file
 */
public class FileProcessor {

	private String filename;
	BufferedReader reader;

	/**
	 *   The default constructor
	 */
	public FileProcessor(){
	}
	
	/**
	 * @param inFile
	 * 
	 * Set the filename by the value passed from command line argument
	 */
	public void setFilename(String inFile){
		this.filename = inFile;
	}
	
	/**
	 * Open the file 
	 */
	public void openFileReader(){
		try {
			this.reader = new BufferedReader(new FileReader(filename));
			if (reader.readLine() == null) {
			    System.out.println("No errors, and file is empty. Please add some values");
			    System.exit(0);
			}
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		}
	}

	/**
	 *  Close the file 
	 */
	public void closeFileReader(){
		try {
			this.reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		} 
	}
	
	/**
	 * @param line
	 * @return integer value
	 */
	public int nextInt(String line) {
			return Integer.parseInt(line);					
	}
		
}

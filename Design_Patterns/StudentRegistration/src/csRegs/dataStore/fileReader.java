package csRegs.dataStore;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import csRegs.util.logger;


interface inf_readFile{
	public void readFile();
}

/* This is a threaded class which reads data from the input file 
 * and stores into registrationStore class' arraylist.
 */
public class fileReader implements Runnable{
	
	BufferedReader input;
	registrationStore rs = new registrationStore();
	/*constructor takes the filename to be read and opens it 
	 *  handling the exceptions
	 */
	public fileReader(String filename) {
		if(logger.getDebugVal()==4)
		{
			logger.dump(logger.getDebugVal(), "Inside fileReader() constructor");
		}
		try{
			File file = new File(filename);
			input = new  BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Not Found!");
			System.exit(0);
		}
	}
	
	// Initialize thread
	public void run(){
		if(logger.getDebugVal()==3)
		{
			logger.dump(logger.getDebugVal(), "Thread For Reading File");
		}
		readFile();
	}
	
	// Our actual function which reads the file
	public synchronized void readFile(){
		try{		 
			 String strline; 
			 while((strline=input.readLine()) !=null){
					 /* read all the lines one by one and split the line
					  * into data structure we want to create 
					  * and store in the registrationStore class
					  */
					String[] details = strline.split(" ");
					rs.addStudentData(details[0], details[1], details[2], Integer.parseInt(details[3]));
			}
		}
		catch(IOException e){
			System.out.println("IO exception detected!!");
		}
		catch (NullPointerException e) {
			System.out.println("Null Pointer Exception!! ");
		}
		catch(NumberFormatException e){
			System.out.println("NumberFormatException!! Check the format of data file at this input line\n");
		}
		
		
	}
}

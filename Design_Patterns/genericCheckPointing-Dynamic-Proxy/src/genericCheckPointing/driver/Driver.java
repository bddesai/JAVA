package genericCheckPointing.driver;
import java.util.ArrayList;

import genericCheckPointing.djsonStoreRestore.StoreRestoreHandler;
import genericCheckPointing.server.RestoreI;
import genericCheckPointing.server.StoreI;
import genericCheckPointing.server.StoreRestoreI;
import genericCheckPointing.util.EmployeeRecord;
import genericCheckPointing.util.ProxyCreator;
import genericCheckPointing.util.SerializableObject;
import genericCheckPointing.util.StudentRecord;

/**
 * @author Bhavin
 * This is the main driver code 
 */
public class Driver {
	
	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		if(args.length!=2){
			System.out.println("Inappropriate Number of Arguments");
			System.exit(0);
		}
		int NUM_OF_OBJECTS = 0; 
		String filename = null;
		try{
			// Read the value of NUM_OF_OBJECTS from the command line
			NUM_OF_OBJECTS = Integer.parseInt(args[0]);
			if(NUM_OF_OBJECTS<0 || NUM_OF_OBJECTS > 15){
				System.out.println("NUM_OF_OBJECTS should be between 0 and 15");
				System.exit(0);
			}
				
			// Read the value of checkpointFile from the command line
			filename = args[1];
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Arguments!!");
		}
		catch(NumberFormatException e){ System.out.println("Number Format Exception! Check Argument Format");}
		catch(NullPointerException e){System.out.println("Null Pointer Exception!!");}
		
		ProxyCreator pc = new ProxyCreator();
		
		// create an instance of StoreRestoreHandler (which implements the InvocationHandler)
		StoreRestoreHandler handler =  new StoreRestoreHandler();
		handler.setFilename(filename);
		
		// invoke a method on the DJSONHandler instance to set the file name for checkpointFile and open the file
		try{
			handler.openFileWriter();
		
			// create a proxy
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
										 new Class[] {
										     StoreI.class, RestoreI.class
										 }, 
										 handler
										);
				
			SerializableObject myErecord, mySrecord;
			ArrayList<SerializableObject> writearr = new ArrayList<SerializableObject>();
			
			for (int i=0; i<NUM_OF_OBJECTS; i++) {
			    myErecord = new EmployeeRecord(i);
			    mySrecord = new StudentRecord(i);
		
			    ((StoreI) cpointRef).writeDJSON(myErecord, "djson");
			    writearr.add(myErecord);
			    ((StoreI) cpointRef).writeDJSON(mySrecord, "djson");
			    writearr.add(mySrecord);
			}
			//System.out.println("writeArray: "+writearr);
			//  invoke a method on the DJSONHandler instance to close the file
			handler.closeFileWriter();
			
			
			handler.openFileReader();
			SerializableObject myRecordRet;
			ArrayList<SerializableObject> readarr = new ArrayList<SerializableObject>();
			
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {
		
			    myRecordRet = ((RestoreI) cpointRef).readDJSON("djson");
			    // FIXME: store myRecordRet in a data structure
			    readarr.add(myRecordRet);	    
			}
			//  invoke a method on the DJSONHandler instance to close the file
			handler.closeFileReader();
			//System.out.println("\nreadArray: " + readarr);

			
			// compare and confirm that the serialized and deserialzed objects are equal
			for(int i=0; i<NUM_OF_OBJECTS;i++)
			{
				if(writearr.get(i).equals(readarr.get(i)))
					System.out.println((i+1)+" Record Matches");
			}
			
		}
		catch(NullPointerException e){System.out.println("Null Pointer Exception!! Check your arguments");}
		
	}
}

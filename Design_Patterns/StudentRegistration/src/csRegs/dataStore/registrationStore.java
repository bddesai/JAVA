package csRegs.dataStore;
import java.util.Vector;

import csRegs.dataStore.studentInfo;
import csRegs.util.logger;

/* When threads are spawned to read from data file,
 * it stores all the data into ArrayList of this class
 */

public class registrationStore implements inf_registrationStore{
	 
	public registrationStore() {
		if(logger.getDebugVal()==4){
			logger.dump(logger.getDebugVal(), "Inside RegistrationStore constructor");
		}
	}
	// create data structure and store the objects using vector or arraylist
	static Vector<studentInfo> stud = new Vector<studentInfo>();
	
	studentInfo sinfo;

	/* (non-Javadoc)
	 * called by fileReader class to add data to the ArrayList 
	 */
	public void addStudentData(String fname, String lname, String instName, int courseNo)
	{
		sinfo = new studentInfo(fname, lname, instName, courseNo);
		stud.add(sinfo);
	}
	

	/* (non-Javadoc)
	 *  returns the ArrayList of this class 
	 */
	public Vector<studentInfo> getStudArray(){
		return stud;
	}
	
	/* displays all the data which is fed in the arraylist
	 * by using the iterator 	
	 */
	public void displayData(){
		for (studentInfo student : stud) {         
			System.out.println(student.toString());
	      }
		
	}
}

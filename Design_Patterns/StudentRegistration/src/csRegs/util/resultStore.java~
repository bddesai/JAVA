package csRegs.util;

import java.util.Vector;

import csRegs.dataStore.studentInfo;
import csRegs.util.logger;

/* Whatever the data has been matched from registrationStore class
 * will be stored in this class' arraylist
 */

public class resultStore implements inf_resultStore {
	static private Vector<studentInfo> result;
	// Initialize arrayList
	public resultStore() {
		if(logger.getDebugVal()==4){
			logger.dump(logger.getDebugVal(), "Inside resultStore constructor");
		}
		result = new Vector<studentInfo>();
	}

	// Will add matched data into arraylist 
	// This method is called by comparison class
	public void addResultData(studentInfo resinfo)
	{
		result.add(resinfo);
		if(logger.getDebugVal()==2){
			logger.dump(logger.getDebugVal(), "Entry added to Result data structure.");
		}
	}
	
	// returns the ArrayList of this class
	public Vector<studentInfo> getResultArray(){
		return result;
	}
	
	// displays the data of resultStore data stucture
	public void displayData(){
		if(logger.getDebugVal()==1){
			for (studentInfo res : result) {         
				System.out.println(res.toString());
		      }
		}

	}
}



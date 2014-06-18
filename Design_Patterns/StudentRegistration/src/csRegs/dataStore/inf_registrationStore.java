package csRegs.dataStore;

import java.util.Vector;

// The interface implemented by registrationStore class
public interface inf_registrationStore{
	public void displayData();
	public void addStudentData(String fname, String lname, String instName, int courseNo);
	public Vector<studentInfo> getStudArray();
}
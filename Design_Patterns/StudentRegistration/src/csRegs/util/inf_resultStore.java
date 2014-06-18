package csRegs.util;

import java.util.Vector;

import csRegs.dataStore.studentInfo;

// interface that is implemented bu resultStore class
public interface inf_resultStore {
	public void addResultData(studentInfo resinfo);
	public Vector<studentInfo> getResultArray();
	public void displayData();
}

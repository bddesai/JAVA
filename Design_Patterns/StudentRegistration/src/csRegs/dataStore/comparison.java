package csRegs.dataStore;

import java.util.Vector;
import csRegs.util.resultStore;

/* class created to to compare the searched element with 
 * registration store element. 
 */
public class comparison {
	registrationStore rs = new registrationStore();
	Vector<studentInfo> regSt = rs.getStudArray();
	
	resultStore resSt = new resultStore();

	public void compare(String name){

		
		for (int i = 0; i < regSt.size(); i++)
		{
			if((name.equals(name.equals(regSt.get(i).getFname()))) || (name.equals(regSt.get(i).getLname())) || (name.equals(regSt.get(i).getInstName())) || (name.equals(regSt.get(i).getCourseNo())) ){	
				resSt.addResultData(regSt.get(i));
			}
		}		
	}
}

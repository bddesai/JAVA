package csRegs.dataStore;

import csRegs.util.logger;

/* StudentInfo class will have getter setter methods for
 * defining fields that goes into data structure 
 * */
public class studentInfo {
	private String fname;
	private String lname;
	private String InstName;
	private int courseNo;
	
	// constructor will initialize all the fields
	public studentInfo(String fname, String lname, String instName, int courseNo ){
		
		if(logger.getDebugVal()==4){
			logger.dump(logger.getDebugVal(), "Inside studentInfo() constructor");
		}
		
		this.fname = fname;
		this.lname = lname;
		this.InstName = instName;
		this.courseNo = courseNo;
	}
	
	public String getFname(){
		return fname;
	}
	public void setFname(String fn){
		this.fname = fn;
	}
	public String getLname(){
		return lname;
	}
	public void setLname(String ln){
		this.lname = ln;
	}
	public String getInstName(){
		return InstName;
	}
	public void setInstName(String insn){
		this.InstName = insn;
	}
	public int getCourseNo(){
		return courseNo;
	}
	public void setCourseNo(int cn){
		this.courseNo=cn;
	}

	@Override
	public String toString() {
		return "studentInfo [fname=" + fname + ", lname=" + lname
				+ ", InstName=" + InstName + ", courseNo=" + courseNo + "]";
	}
	
	
	
}

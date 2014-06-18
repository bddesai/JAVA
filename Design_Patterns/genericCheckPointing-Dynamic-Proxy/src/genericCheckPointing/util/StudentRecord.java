package genericCheckPointing.util;

/**
 * @author Bhavin
 * General class for StudentRecords having setter and getter methods
 * to play around with objects in use
 */
public class StudentRecord extends SerializableObject {

    private int ii;
    private short ss;
    private boolean bb;
    
    // empty constructor is needed for reflection
    public StudentRecord() {
	// set default values for data members
    }

    public StudentRecord(int iIn) {
    	this.bb = false;
    	this.ii = iIn;
    	this.ss = 'a';
	// set default values for data members
    }

    public void set_ii(int iiIn) {
    	ii = iiIn;
    }
    
    public void set_bb(boolean bbIn) {
    	bb = bbIn;
    }
    public void set_ss(short ssIn) {
    	ss = ssIn;
    }

    
    public int get_ii() {
    	return ii;
    }
    public boolean get_bb() {
    	return bb;
    }
    public short get_ss() {
    	return ss;
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bb ? 1231 : 1237);
		result = prime * result + ii;
		result = prime * result + ss;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		//System.out.println("Student Equals called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentRecord other = (StudentRecord) obj;
		if (bb != other.bb)
			return false;
		if (ii != other.ii)
			return false;
		if (ss != other.ss)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "StudentRecord [ii=" + ii + ", ss=" + ss + ", bb=" + bb + "]";
	}

  
	
}
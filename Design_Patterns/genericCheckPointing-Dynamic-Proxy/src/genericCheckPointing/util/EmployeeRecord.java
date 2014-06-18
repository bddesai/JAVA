package genericCheckPointing.util;

/**
 * @author Bhavin
 * General class for EmployeeRecords having setter and getter methods
 * to play around with objects in use
 */
public class EmployeeRecord extends SerializableObject {
    private int ii;
    private float ff;
    private double dd;
    private long ll;
    // empty constructor is needed for reflection
    public EmployeeRecord() {
	// set default values for data members
    }

    
    public EmployeeRecord(int iIn) {
    	this.ii = iIn;
    	this.ff= 2.3F;
    	this.dd= 4.4;
    	this.ll = 2345;
	// set default values for data members
    }

    // FIXME: rest of the set_X methods
    public void set_ii(int iiIn) {
    	ii = iiIn;
    }
    public void set_ff(float ffIn) {
    	ff = ffIn;
    }
    public void set_dd(double ddIn) {
    	dd = ddIn;
    }
    public void set_ll(long llIn) {
    	ll = llIn;
    }

    

    // FIXME: rest of the get_X methods
    public int get_ii() {
    	return ii;
    }
    
    public float get_ff() {
    	return ff;
    }

    public double get_dd() {
    	return dd;
    }
    
    public long get_ll() {
    	return ll;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ii;
		long temp;
		temp = Double.doubleToLongBits(dd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(ff);
		result = prime * result + (int) (ll ^ (ll >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		//System.out.println("Employee Equals called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRecord other = (EmployeeRecord) obj;
		if (ii != other.ii)
			return false;
		if (Double.doubleToLongBits(dd) != Double.doubleToLongBits(other.dd))
			return false;
		if (Float.floatToIntBits(ff) != Float.floatToIntBits(other.ff))
			return false;
		if (ll != other.ll)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EmployeeRecord [ii=" + ii + ", ff=" + ff + ", dd=" + dd
				+ ", ll=" + ll + "]";
	}
    
    
    

}
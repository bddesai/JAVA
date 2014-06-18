package taskManager.filter;

/**
 * The Performance Filter will  check for performance data in file 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class performanceFilter implements filterInterface {

	@Override
	public boolean valid(String tag) {
		String details[] = tag.split(" ");
		if(details[0].equals("Performance"))
		{
				return true;
		}
		return false;
	}

}

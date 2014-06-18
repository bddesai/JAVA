package taskManager.filter;

/**
 * The process filter will look for process data in file 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class processFilter implements filterInterface{

	@Override
	public boolean valid(String tag) {
		String details[] = tag.split(" ");
		if(details[0].equals("Processes"))
		{
				return true;
		}
		return false;
	}
}

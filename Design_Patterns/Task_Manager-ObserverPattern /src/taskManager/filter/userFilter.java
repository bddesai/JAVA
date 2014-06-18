package taskManager.filter;

/**
 * The user filter looks for user data in input file 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class userFilter implements filterInterface {

	@Override
	public boolean valid(String tag) {
		String details[] = tag.split(" ");
		if(details[0].equals("Users"))
		{
				return true;
		}
		return false;
	}

}

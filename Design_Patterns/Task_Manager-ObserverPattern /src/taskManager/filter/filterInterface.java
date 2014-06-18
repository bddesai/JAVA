package taskManager.filter;

/**
 * It will have a valid method to be overrided by the filter classes
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public interface filterInterface {
	/**
	 * @param tag
	 * @return boolan
	 */
	public boolean valid(String tag);
}

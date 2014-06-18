package taskManager.observer;

import taskManager.info.tabInfo;

/**
 * This is oberver interface which has an update method which will 
 * be overrided by all three observer classes 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public interface observerInterface {
	/**
	 * @param tb
	 */
	public void update(tabInfo tb); 
}

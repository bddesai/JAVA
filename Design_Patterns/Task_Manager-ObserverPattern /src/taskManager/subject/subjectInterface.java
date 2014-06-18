package taskManager.subject;

import taskManager.filter.filterInterface;
import taskManager.observer.observerInterface;

/**
 * This interface has methods which are implemented by 
 * subjectClass to register, remove and notify the observers
 * 
 * @author Bhavin Desai, Sudeep Abhyankar 
 *
 */
public interface subjectInterface {
	/**
	 * @param po
	 * @param filter
	 */
	public void registerObserver(observerInterface po, filterInterface filter);
	
	
	/**
	 * @param deleteobs
	 */
	public void unregisterObserver(observerInterface deleteobs);
	
	
	/**
	 * @param type
	 */
	public void notifyObserver(String type);
	
	/**
	 * @param line
	 */
	public void exportLine(String line);
}

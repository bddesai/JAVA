package taskManager.observer;

import java.util.ArrayList;

import taskManager.display.displayClass;
import taskManager.info.tabInfo;
import taskManager.util.logger;

/**
 * This class sets the new values for the users observer 
 * and adds to the local arraylist 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class UsersObserver implements observerInterface{

	@Override
	public void update(tabInfo tb) {
		
		String username, status;
		
		username = tb.getUsername();
		status = tb.getStatus();
		
		ArrayList<String> user= new ArrayList<String>();
		user.add(username);
		user.add(status);
		
		if(logger.getDebugVal()==3){
			logger.dump(logger.getDebugVal(), "Users Tab Updated ");
		}
		
		if(logger.getDebugVal()==1){
			logger.dump(logger.getDebugVal(), "-- Users Tab --");
			displayClass data = new displayClass();
			data.display(user);
			System.out.println("\n");
		}
	}



}

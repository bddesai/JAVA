package taskManager.driver;

import taskManager.util.logger;
import taskManager.filter.performanceFilter;
import taskManager.filter.processFilter;
import taskManager.filter.userFilter;
import taskManager.observer.PerformanceObserver;
import taskManager.observer.ProcessesObserver;
import taskManager.observer.UsersObserver;
import taskManager.subject.SubjectClass;
import taskManager.subject.subjectInterface;
import taskManager.util.readFile;

/**
 * This is our driver code that will check for boundary conditions of
 * parameters and wil generate an object of subject class through 
 * which we will register the observer. We than call the filter methods
 * to filter the data and update the respective observer
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		try{
			if(args.length!=2){
				System.out.println("Usage: <input FileName> <DEBUG_VALUE> ");
				System.exit(0);
			}
		
			String filename= args[0];
			int debug =  Integer.parseInt(args[1]);
		
			if(debug<0 || debug >4){
				System.out.println("Wrong Debug Value");
				System.exit(0);
			}
			logger.setDebugVal(debug);
		
			subjectInterface sc = new SubjectClass();
		
			UsersObserver user = new UsersObserver();
			PerformanceObserver performance = new PerformanceObserver();
			ProcessesObserver processes = new ProcessesObserver();
		
			userFilter filter = new userFilter();
			sc.registerObserver(user, filter);
		
			performanceFilter pfilter = new performanceFilter();
			sc.registerObserver(performance, pfilter);
		
			processFilter profilter = new processFilter();
			sc.registerObserver(processes,profilter);
		
			readFile rf = new readFile(filename, sc);
			rf.readingFile();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Number Format Exception !! Verify input parameters");
		}		
		
	}

}

package taskManager.observer;

import java.util.ArrayList;

import taskManager.util.logger;
import taskManager.display.displayClass;
import taskManager.info.tabInfo;

/**
 * 
 * This class sets the new values for the processes observer 
 * and adds to the local arraylist 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class ProcessesObserver implements observerInterface{

	@Override
	public void update(tabInfo tb) {
		
		String procname, p_username, CPU, memory, description;
		
		procname = tb.getProcessName();
		p_username = tb.getP_username();
		CPU = tb.getCPU();
		memory = tb.getMemory();
		description = tb.getDescription();
		
		
		ArrayList<String> process= new ArrayList<String>();
		process.add(procname);
		process.add(p_username);
		process.add(CPU);
		process.add(memory);
		process.add(description);
		
		if(logger.getDebugVal()==3){
			logger.dump(logger.getDebugVal(), "Processes Tab Updated ");
		}
		
		if(logger.getDebugVal()==1){
			logger.dump(logger.getDebugVal(), "-- Processes Tab --");
			displayClass data = new displayClass();
			data.display(process);
		}
		
		
	}



}

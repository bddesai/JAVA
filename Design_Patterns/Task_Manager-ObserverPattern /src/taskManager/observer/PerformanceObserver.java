package taskManager.observer;

import java.util.ArrayList;

import taskManager.display.displayClass;
import taskManager.info.tabInfo;
import taskManager.util.logger;



/**
 * This class sets the new values for the performance observer 
 * and adds to the local arraylist 
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class PerformanceObserver implements observerInterface{
	@Override
	public void update(tabInfo tb){
		String currMem, currCPU, physical, cached;
		
		currMem = tb.getCurrMem();
		currCPU = tb.getCPU();
		physical = tb.getPhysical();
		cached = tb.getCached();
		
		ArrayList<String> perf= new ArrayList<String>();
		perf.add(currMem);
		perf.add(currCPU);
		perf.add(physical);
		perf.add(cached);
		
		if(logger.getDebugVal()==3){
			logger.dump(logger.getDebugVal(), "Performance Tab Updated ");
		}
		
		if(logger.getDebugVal()==1){
			logger.dump(logger.getDebugVal(), "-- Performance Tab --");
			displayClass data = new displayClass();
			data.display(perf);
		}
	
	}
}
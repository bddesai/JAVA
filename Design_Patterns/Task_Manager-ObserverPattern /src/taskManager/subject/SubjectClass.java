package taskManager.subject;
import java.util.HashMap;
import java.util.Map;

import taskManager.observer.observerInterface;
import taskManager.util.logger;
import taskManager.filter.filterInterface;
import taskManager.info.tabInfo;


/**
 * Subject class will implement three methods to register, remove and 
 * notify the observers 
 * 
 * @author Bhavin Desai, Sudeep Abhyankar
 *
 */
public class SubjectClass implements subjectInterface{
		
		static String line, type;
		private static Map<observerInterface, filterInterface> obsdata;
		static tabInfo tinfo;
		public SubjectClass(){
			if(logger.getDebugVal()==2){
				logger.dump(logger.getDebugVal(), "Inside SubjectClass constructor");
			}
			obsdata= new HashMap<observerInterface, filterInterface>();
			tinfo = new tabInfo();
		}
		public  void exportLine(String inLine){
			line = inLine;
		}
				
		
	
		public void registerObserver(observerInterface newobs, filterInterface filter) {
				if(logger.getDebugVal()==4){
					logger.dump(logger.getDebugVal(), "Observer Registered");
				}
				obsdata.put(newobs, filter);
		}

		@Override
		public void unregisterObserver(observerInterface deleteobs) {
			if(logger.getDebugVal()==4){
				logger.dump(logger.getDebugVal(), "Observer Deleted ");
			}

			
			if(deleteobs==null)
				System.out.println("Cannot Delete Observer without Registering ");
			
			obsdata.remove(deleteobs);
		}

			public  void notifyObserver(String type){
			
				try {
					String details[] = line.split(" ");
					type = details[0];
					
					if(type.equals("Performance"))
					{
						
						tinfo.setCurrMem(details[1]);
						tinfo.setCurrCPU(details[2]);
						tinfo.setPhysical(details[3]);
						tinfo.setCached(details[4]);
						
					}
					else if (type.equals("Processes"))
					{
						tinfo.setProcessName(details[1]);
						tinfo.setP_username(details[2]);
						tinfo.setCPU(details[3]);
						tinfo.setMemory(details[4]);
						tinfo.setDescription(details[5]);
						
					}
					else if(type.equals("Users"))
					{
						tinfo.setUsername(details[1]);
						tinfo.setStatus(details[2]);
					}
	
					observerInterface obstab ;
					filterInterface filter;
					
					for(Map.Entry<observerInterface, filterInterface> entry : obsdata.entrySet()){
						obstab = entry.getKey();
						filter = entry.getValue();
						
						if(filter.valid(type)==true){
							obstab.update(tinfo);
					}
				}
	
				} catch (Exception e) {
					System.out.println(e + "");
				}
		}

}

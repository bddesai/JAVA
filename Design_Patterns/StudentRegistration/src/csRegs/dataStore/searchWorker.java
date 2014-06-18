package csRegs.dataStore;
import csRegs.dataStore.searchFile;
import csRegs.util.logger;


/* This class spawns threads to call searchFile class
 * which will read our search file
 * */
public class searchWorker implements inf_searchWorker{
	
	private String file;
	private int numThread;
	
	// filename and number of threads comes from command line
	public searchWorker(String filename, int numThreads) {
		file=filename;
		numThread = numThreads;
		if(logger.getDebugVal()==4){
			logger.dump(logger.getDebugVal(), "Inside searchWorker constructor");
		}
	}
	
	/* The function that will generate threads by invoking
	 * searchFile class 
	 * */
	public void generateSearchThreads(){
		searchFile sr = new searchFile(file);
		
		// generating threads
		Thread[] searchThread = new Thread[numThread];
		for(int i=0;i<numThread;i++){
			searchThread[i] = new Thread(sr);
			searchThread[i].start();
		}
		
		// thread joins
		try{
			for(int i=0;i<numThread;i++){
				searchThread[i].join();
			}
		}
		catch(InterruptedException ex){
			System.out.println("Threads interrupted");
		}
		
	}
}

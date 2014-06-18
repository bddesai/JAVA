package csRegs.dataStore;
import csRegs.dataStore.fileReader;
import csRegs.util.logger;


/* This class will spawn threads to call file reader class
 * that will read data file.
 */
public class populateWorker implements inf_populateWorker{
	//create threads to read file 
	private String file;
	private int numThread;
	
	// Take filename and number of threads to spawn from command line
	public populateWorker(String filename, int numThreads) {
		if(logger.getDebugVal()==4)
		{
			logger.dump(logger.getDebugVal(), "Inside PopulateWorker constructor");
		}
		file=filename;
		numThread = numThreads;
	}
	
	
	/* This function will spawn threads to read from file
	 * Threads are joined so that main thread does not exits before
	 * the child thread
	 */
	public void generateThreads(){
		
		fileReader fr = new fileReader(file);
		
		// start number of threads 
		Thread[] readThread = new Thread[numThread];
		for(int i=0;i<numThread;i++){	
			readThread[i] = new Thread(fr);
			readThread[i].start();
		}
		
		// Join threads 
		try{
			for(int i=0;i<numThread;i++){
				readThread[i].join();
			}
		}
		catch(InterruptedException ex){
			System.out.println("Threads interrupted");
		}
	}
}

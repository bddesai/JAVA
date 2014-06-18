package chat.util;
/*
 * This class is designed so that ServerHandler can borow a Thread
 * from thread pool. We will attach a flag value to all the threads
 * to decide which is eligible to be borrowed 
 * */
public class threadPool{
	static int numThreads = 5;
	private static Thread[] threadsArray = new Thread[numThreads];
	int[] flag= new int[numThreads];
	public volatile static threadPool thpool= null ;
	
	private threadPool(){
		for(int i= 0; i<numThreads;i++){
			flag[i]=0;
		}
	}
	
	/* 
	 * As this is a singleton class, it will create an instance 
	 * if the instance of the class does not exist. Also we will 
	 * apply double locking for threads synchronization. It will
	 * avoid race conditions.
	 * 
	 * @return threadPool instance
	 */
	public static threadPool getInstance(){
		if(thpool == null){
			synchronized (threadPool.class) {
				if (thpool== null){
					thpool = new threadPool();
				}
			}
			
		}
		return thpool;
	}
	
	/*
	 * Whenever a thread is borrowed its status will turn to 1
	 * because if the next time the thread comes, it will know that 
	 * only the threads with 0 status are free to be borrowed
	 * 
	 * @return : borrowed Thread 
	 */
	public Thread borrowThread(){
		Thread t = null;
		 for (int i = 0; i < numThreads; i++){
			    if (flag[i] ==0){
			    	flag[i]=1;
			    	t= threadsArray[i]; 
			    }
	            
	        }
		 return t;
	}
}
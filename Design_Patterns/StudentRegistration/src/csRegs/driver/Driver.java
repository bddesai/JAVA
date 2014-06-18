package csRegs.driver;


import csRegs.dataStore.inf_populateWorker;
import csRegs.dataStore.inf_searchWorker;
import csRegs.dataStore.populateWorker;
import csRegs.dataStore.searchWorker;
import csRegs.util.inf_resultStore;
import csRegs.util.logger;
import csRegs.util.resultStore;
public class Driver {
	public static void main(String args[])
	{
		// Command line arguments 
		
		if(args.length !=5)
		{
			System.out.println("Usage: <inputDataFileName> <NN> <searchFileName> <MM> <DEBUG_VALUE> ");
			System.exit(0);
		}
		try{
			String readfile = args[0];
			int NNread = Integer.parseInt(args[1]);
			String searchfile = args[2];
			int MMsearch = Integer.parseInt(args[3]);
			int debug =  Integer.parseInt(args[4]);

			if(NNread<1 || NNread>15){
				System.out.println(" Read threads should be between 1 and 15");
				System.exit(0);
			}
			else if(MMsearch<1 || MMsearch>15){
				System.out.println("Search threads should be between 1 and 15");
				System.exit(0);
			}
			else if(debug<0 || debug>4){
				System.out.println("Debug value should be 1 to 4");
				System.exit(0);
			}
			
			
			logger.setDebugVal(debug);
			
			inf_populateWorker pop = new populateWorker(readfile, NNread);
			pop.generateThreads();
			
			inf_resultStore res = new resultStore();
			inf_searchWorker search = new searchWorker(searchfile, MMsearch);
			search.generateSearchThreads();
			
			
			res.displayData();
			
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Number of Arguments !!");
		}
		catch(NumberFormatException e){
			System.out.println("Number Format Exception !! Check your arguments");
		}
		
		
	}
}

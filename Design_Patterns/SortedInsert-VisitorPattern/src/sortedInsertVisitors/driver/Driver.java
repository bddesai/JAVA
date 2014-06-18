package sortedInsertVisitors.driver;

import sortedInsertVisitors.util.FileProcessor;
import sortedInsertVisitors.util.MyArray;
import sortedInsertVisitors.util.MyVector;
import sortedInsertVisitors.util.SlowInsertVisitor;
import sortedInsertVisitors.util.SortedInsertVisitor;

/**
 * @author Bhavin
 *
 * The actual driver code 
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 if(args.length!=1)
		 {
			 System.out.println("Check the number of arguments!!");
			 System.exit(0);
		 }
		String filename=null;
		filename = args[0];
		
		FileProcessor fp = new FileProcessor();
		fp.setFilename(filename);
		
		MyArray arr = new MyArray();
		MyVector vec = new MyVector();
		
		SortedInsertVisitor fastsiv = new SortedInsertVisitor(fp);
		SlowInsertVisitor slowsiv = new SlowInsertVisitor(fp);
		
		try {
		arr.accept(fastsiv);
		arr.accept(slowsiv);
		
		vec.accept(fastsiv);
		vec.accept(slowsiv);
		}
		catch(NullPointerException e){
			System.out.println("Null Pointer Exception. Reconsider checking the name of file");
		}
		catch (NumberFormatException e) {
			System.out.println("Number Format Exception. Your file cannot have empty lines");
		}
	}
	

}

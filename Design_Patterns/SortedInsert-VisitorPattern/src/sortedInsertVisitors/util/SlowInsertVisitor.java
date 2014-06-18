package sortedInsertVisitors.util;

import java.io.IOException;

/**
 * @author Bhavin
 *
 * This class helps to implement the slow sorting logic 
 */
public class SlowInsertVisitor implements Visitor{

	private int insVal;
	FileProcessor fp;
	
	/**
	 * @param fpIn
	 */
	public SlowInsertVisitor(FileProcessor fpIn){
		this.fp=fpIn;
	}
	
	/* 
	 * open, read and close the file with the help of 
	 *  FileProcessor Object. After reading each line 
	 *  call the respective method of MyVector class.
	 */
	public void visit(MyArray arrObj){
		fp.openFileReader();
		
		try {
			String line=null;
			while((line = fp.reader.readLine()) != null ){
				insVal = fp.nextInt(line);
				arrObj.postSortArray(insVal);
			}
		} catch (IOException e) {
			System.out.println("IO Exception !");
		}
		System.out.println("\n\nSlowInsert - ArrayList: ");
		arrObj.display();
		fp.closeFileReader();
	}
	
	/* 
	 * open, read and close the file with the help of 
	 *  FileProcessor Object. After reading each line 
	 *  call the respective method of MyVector class.
	 */
	public void visit(MyVector vec){
		// invoke methods of myVector
		fp.openFileReader();
		
		try {
			String line=null;
			while((line = fp.reader.readLine()) != null ){
				insVal = fp.nextInt(line);
				vec.postSortVector(insVal);
			}
		} catch (IOException e) {
			System.out.println("IO Exception !");
		}
		System.out.println("\n\nSlowInsert - Vector:");
		vec.display();
		fp.closeFileReader();
		
	}
	
}

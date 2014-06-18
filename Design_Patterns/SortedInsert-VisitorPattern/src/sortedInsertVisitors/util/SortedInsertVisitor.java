package sortedInsertVisitors.util;

import java.io.IOException;

/**
 * @author Bhavin
 *
 * This class helps to implement the sorted insert logic 
 */
public class SortedInsertVisitor implements Visitor{
	
	private int insVal;
	FileProcessor fp;
	
	/**
	 * @param fpIn
	 */
	public SortedInsertVisitor(FileProcessor fpIn){
		this.fp=fpIn;
	}
	
	
	/* 
	 *  open, read and close the file with the help of 
	 *  FileProcessor Object. After reading each line 
	 *  call the respective method of MyArray class.
	 */
	public void visit(MyArray arrObj){
		fp.openFileReader();
		
		try {
			String line=null;
			while((line = fp.reader.readLine()) != null ){
				insVal = fp.nextInt(line);
				arrObj.sortedInsertArray(insVal);
			}
		} catch (IOException e) {
			System.out.println("IO Exception !");
		}
		System.out.println("Sorted Insert - ArrayList: ");
		arrObj.display();
		fp.closeFileReader();
	}
	
	/* 
	 * open, read and close the file with the help of 
	 *  FileProcessor Object. After reading each line 
	 *  call the respective method of MyVector class.
	 */
	public void visit(MyVector vecObj){
		fp.openFileReader();
		
		try {
			
			String line=null;
			while((line = fp.reader.readLine()) != null ){
				insVal = fp.nextInt(line);
				vecObj.sortedInsertVector(insVal);
			}
		} catch (IOException e) {
			System.out.println("IO Exception !");
		}
		System.out.println("\n\nSorted Insert - Vector: ");
		vecObj.display();
		fp.closeFileReader();
		
	}
	
}

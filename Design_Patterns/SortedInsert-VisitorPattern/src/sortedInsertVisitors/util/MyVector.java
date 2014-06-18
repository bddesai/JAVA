package sortedInsertVisitors.util;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Bhavin
 * 
 * This class contains the vectors on which the sorting operations 
 * are to be performed.
 */
public class MyVector {
	Vector<Integer> vector = new Vector<Integer>();
	Vector<Integer> newvector = new Vector<Integer>();
	private int n=0;
	
	/**
	 * Display the vectors
	 */
	public void display(){
		for (Integer number : vector) {         
	         System.out.println("Index :"+vector.indexOf(number) +" Number: " + number);
	      }
	}
	
	/**
	 * @param visit
	 */
	public void accept(Visitor visit){
		visit.visit(this);
	}
	
	/**
	 * @param insVal
	 */
	public void sortedInsertVector(int insVal){
		int index, pos;
		if(n==0)
			vector.add(insVal);
		else
		{
			index = Collections.binarySearch(vector, insVal);
			pos = -(index + 1);
			vector.add(pos, insVal);
		}
		n++;
	}
	
	/**
	 * @param insVal
	 */
	public void postSortVector(int insVal){
		newvector.add(insVal);
		Collections.sort(newvector);
	}
}

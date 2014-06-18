package sortedInsertVisitors.util;

import java.util.ArrayList;
import java.util.Collections;

//import java.util.Arrays;

/**
 * @author Bhavin
 *
 * This class contains the arrays on which the sorting operations 
 * are to be performed.
 */
public class MyArray {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> slowarray= new ArrayList<Integer>();
		int n=0;

		
		/**
		 *  Display the arrays
		 */
		public void display(){
			for(int i=0; i<n;i++){
				  System.out.print(array.get(i).toString()+"  ");
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
		public void sortedInsertArray(int insVal){
			int index, pos;
			if(n==0)
				array.add(insVal);
			else
			{
				index = Collections.binarySearch(array, insVal);
				pos = -(index + 1);
				array.add(pos, insVal);
			}
			n++;
		}
		
		
		/**
		 * @param insVal
		 */
		public void postSortArray(int insVal){
			slowarray.add(insVal);
			Collections.sort(slowarray);
		}

}		

package taskManager.display;

import java.util.ArrayList;


/**
 * This is the displayClass that has a method which will display the
 * results from different Observers
 * 
 * @author Bhavin Desai,  Sudeep Abhyankar
 */
public class displayClass implements displayInterface{

	@Override
	public void display(ArrayList<String> print) {
		
		StringBuilder builder = new StringBuilder();
		for (String value : print) {
		    builder.append(value+" ");
		}
		String text = builder.toString();
		System.out.println(text);
	}
	
}

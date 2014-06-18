package genericCheckPointing.djsonStoreRestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @author Bhavin
 * This is a handler class which will have operations to open and close file
 * and the invoke method will be use to serialize and deserialize objects 
 */
public class StoreRestoreHandler implements InvocationHandler{

	String filename;
	
	public StoreRestoreHandler(){
	}
	
	/**
	 * @param inFile
	 */
	public void setFilename(String inFile){
		this.filename = inFile;
	}
	
	// method to open file 
	FileWriter writer;
	BufferedReader reader;
	/**
	 * 
	 */
	public void openFileWriter(){
		try {
			this.writer = new FileWriter(filename);
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		}
	}
	public void openFileReader(){
		try {
			this.reader = new BufferedReader(new FileReader(filename));
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		}
	}

	public void closeFileWriter(){
		try {
			this.writer.close();
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		} 
	}
	public void closeFileReader(){
		try {
			this.reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception!!");
		} 
	}

	
	// create an invocation handler
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {		
			
			Object obj = null;
			String methodName = method.getName();
			try{
				/* 
				 * Logic to call the method writeDJSON
				 */
				if(methodName.equals("writeDJSON")){
					
					  // write logic
					  Field[] cfield = args[0].getClass().getDeclaredFields();
					  writer.write(args[0].getClass().getName()+" ");				  
					  for(int i=0; i<cfield.length;i++){
						  	  cfield[i].setAccessible(true);
							  writer.write(cfield[i].getName()+" "+ cfield[i].getType()+" "+cfield[i].get(args[0])+" ");
					  }
					  writer.write("\n");
				}
	
				/*
				 *  Logic to call the method readDJSON 
				 */
				if(methodName.equals("readDJSON")){
					String line;
					while ((line=reader.readLine())!=null){
						String tokens[] = line.split(" ");
						
						// retrieve class 
						Class<?> clsName = Class.forName(tokens[0]);
						obj = clsName.newInstance();
						
						Method[] m = clsName.getDeclaredMethods();
						
						/* Check all datatypes, and based on that invoke respective methods
						 * on the class object to set values 
						 */
						for(int i=0;i<tokens.length;i++){
							if(tokens[i].equals("int")){
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_ii")){
										Object[] paramInt = {Integer.parseInt(tokens[i+1])};
										m[j].invoke(obj, paramInt);
									}
								}
							}
							if(tokens[i].equals("boolean")){ 					
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_bb")){
										Object[] paramBool = {Boolean.parseBoolean(tokens[i+1])};
										m[j].invoke(obj, paramBool);
									}
								}
							}
							if(tokens[i].equals("short")){ 					
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_ss")){
										Object[] paramShort = {Short.parseShort(tokens[i+1])};
										m[j].invoke(obj, paramShort);
									}
								}
							}
							if(tokens[i].equals("float")){ 					
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_ff")){
										Object[] paramFloat = {Float.parseFloat(tokens[i+1])};
										m[j].invoke(obj, paramFloat);
									}
								}
							}
							if(tokens[i].equals("long")){ 					
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_ll")){
										Object[] paramLong = {Long.parseLong(tokens[i+1])};
										m[j].invoke(obj, paramLong);
									}
								}
							}
							if(tokens[i].equals("double")){
								for(int j=0;j<m.length; j++){
									if(m[j].toString().contains("set_dd")){
										Object[] paramDouble = {Double.parseDouble(tokens[i+1])};
										m[j].invoke(obj, paramDouble);
									}
								}
							}
							
						}// end for 
						
						//return all object back to mainwhile reading each line
						return obj;  
					} // end while
					
				}// end if 
			}
			catch(ClassCastException e){System.out.println("Class Cast Exception");}
			catch(InstantiationException e){System.out.println("Instantiation Exception");}
			catch (IllegalAccessException e) {System.out.println("Illegal Access Exception");}
		
			return obj;		
	}
}

package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import chat.util.logger;


/*
 * This is a thread class which accepts the socket connection
 * and spawns threads for connecting to clients.
 * It performs various operations as given in menu 
 * 1. Send message to a client
 * 2. Print Messages from Client
 * 3. Quit.
 * 
 */
public class ServerHandler implements Runnable  {
	
	// set the socket recieved from driver code
	Socket ssock;
	public ServerHandler(Socket ssockIn){
		this.ssock = ssockIn;
		
	}

	public StringBuffer ClientMsg= new StringBuffer(""); 
	public void run(){
		
		while(true){			
		
	    	try{

				System.out.println("\n1. Send message to a client");
				System.out.println("2. Print Messages from a client");
				System.out.println("3. Quit");
				System.out.print("\n>>> ");   				
				
		    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		        String option = bufferRead.readLine();
		     
		        int choice = Integer.parseInt(option);
		        
		        // get Input and OutputStream 
				BufferedReader bufferIn = new BufferedReader(new InputStreamReader(ssock.getInputStream()));
		        PrintWriter writer = new PrintWriter(ssock.getOutputStream());
		        
		        
				switch(choice)
				{
				   case 1:  // Send message to client 
					   	 String smsg = bufferRead.readLine();
					   	 smsg = "Server>> "+ smsg;
				   		 writer.println(smsg);
						 ClientMsg.append(smsg);
						 writer.flush();
					   	break;
					   	
				   case 2:  // Print messages from client
					   	smsg = bufferIn.readLine();
					   	ClientMsg.append(smsg);
					   	ClientMsg.append("\n");
					   	// dump message to a file 
					   	if(smsg.contains("BACKUP")){
					        	logger.dump(ClientMsg.toString());
					        }
					   	
					   	System.out.println(smsg);
					   	
						break;
						
				   case 3: // Exit the server
					   		ssock.close();
				   			System.exit(0);	
				   		break;
				   default:   System.out.println("Inappropriate Selection");
						break;
				}
			}
		    catch(IOException e)
		    {
		        System.out.println("IO Exception !!");
		  	}
	    	catch(NumberFormatException e){
	    		System.out.println("Number Format Exception !!");
	    	}
	    	
		   } //END WHILE
	    } // END RUN
}

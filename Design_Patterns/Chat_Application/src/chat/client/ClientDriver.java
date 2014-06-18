package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/*
 * ClientDriver is ur client code through which we can connect to 
 * Server code. It displays a menu to connect to the server in various
 * ways. Finally quit option exits the server. It writes to server 
 * getOutputStream and recieves messages through
 * getInputStream. 
 * 
 * @author : Bhavin Desai 
 * 
 * */
public class ClientDriver {

	public static void main(String[] args) {
		
		if(args.length!=2){
			System.out.println("Inappropriate arguments");
			System.exit(0);
		}
		
		String sname = args[0];
		int port = Integer.parseInt(args[1]);
		if(args[1].length()!=4){
			System.out.println("Port Number Should be 4 digits");
			System.exit(0);
		}
		Socket client;
	    try{
	    	
	    	client = new Socket(sname, port);
	    	String cname="";
	    	
	    	while(true)
	    	{

				System.out.println("\n1. Give me a name ");
				System.out.println("2. Send message to Server");
				System.out.println("3. Print Messages from Server");
				System.out.println("4. Quit");
				System.out.print("\n>>> ");
				
		        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
		        PrintWriter writer = new PrintWriter(client.getOutputStream());
		        String option = bufferRead.readLine();	        
		        int choice = Integer.parseInt(option);
		        
				switch(choice)
				{
				   case 1:  System.out.println("\nGive Name:");
				   		cname = bufferRead.readLine();
				   		System.out.println(cname);
						break;
				   case 2:  // send msg to server
				   		String smsg = bufferRead.readLine();
				   		smsg = cname+">> "+smsg;
				   		writer.println(smsg);
				   		writer.flush();
					   	break;
				   case 3:  //print messages from server
					   	System.out.println(bufferIn.readLine());
						break;
				   case 4:  client.close();
				   			  System.exit(0);	
				   		break;
				   default:   System.out.println("Inappropriate Selection");
						break;
				}
	    	}
	    }
	    catch(IOException e){
	        System.out.println("IO Exception !!");
	    }
	    catch(NumberFormatException e){
	    	System.out.println("Number Fomat Exception !!");
	    }
		
	}

}

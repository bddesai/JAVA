package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import chat.util.threadPool;
/*
 * The ServerDriver code will access the ServerHandler class 
 * which is a thread handler by which threads can be borrowed 
 * from the pool. Opens and closes the socket connection for
 * Server
 */
public class ServerDriver {
	
		public static void main(String[] args)  {
			
			if(args.length!=1){
				System.out.println("Inappropriate arguments");
				System.exit(0);
			}
			if(args[0].length()!=4){
				System.out.println("Port Number Should be 4 digits");
				System.exit(0);
			}
			
			int port = Integer.parseInt(args[0]);
			
			ServerSocket serversocket = null;
			try{
				serversocket  = new ServerSocket(port);
					while(true)
					{
						Socket server = serversocket.accept();
						ServerHandler handler = new ServerHandler(server);
						threadPool thpool = threadPool.getInstance();
						Thread t1 = thpool.borrowThread();
						t1=new Thread(handler);
						t1.start();
					}
			}
			catch(IOException e){
				System.out.println("IO Exception !!!");
			}
			finally{
				try{
					serversocket.close();
				}
				catch(IOException e){
					System.out.println("IO Exception");
					
				}
			}
		}
}

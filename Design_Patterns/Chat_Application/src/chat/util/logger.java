package chat.util;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/*
 * The logger class will take the stringbuffer as a string 
 * from the ServerHandler everytime the server detects that 
 * client has sent the BACKUP message. Upon receiving "BACKUP"
 * it will write all the client messages stored in stringBuffer
 * to a backup file.
 * 
 * @return void (nothing because we are simply writing to a file )
 */
public class logger {
		
	public static void dump(String data) {

		 String filename = "backup.txt";
		 try{
	      PrintWriter writer = new PrintWriter(filename);
	        writer.write(data);
			writer.close();
	        
		 }
		 catch(FileNotFoundException e){
			 System.out.println("File NOT Found");
		 }
		 
		
	}
}

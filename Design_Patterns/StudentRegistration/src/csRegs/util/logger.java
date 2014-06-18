package csRegs.util;


/*  This our debugging class 
 *  based on the values it will display messages in entire code
 */
public class logger {
	private static int debugval;
	private static String msg;

	//  Getter and setter methods for Debug Value 
	// and the message to be displayed along
	
	public static int getDebugVal(){
		return debugval;
	}
	public static void setDebugVal(int dval){
		debugval = dval;
	}
	
	public static String getMessage(){
		return msg;
	}
	public static void setMessage(String message){
		msg = message;
	}
	
	// dump() method will be called at various places 
	// to display appropriate messages
	public static void dump(int val, String msg){

		if(val==debugval){
			System.out.println(msg);
		}
		
			
	}
}

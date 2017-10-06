
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public final class client {

    public static void main(String[] args) throws Exception, InterruptedException {
        
    	try (Socket socket = new Socket("18.221.102.182", 38001)) 
        {
			String username = "Shadman48";
			
			//Send user name.
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os, true, "UTF-8");
			ps.println(username);
			
			
		
       	
        	
        	//Receive response from server.
			
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
			String serverOutput = br.readLine();
				
			Runnable chatLog = () -> 
	        {
	            
	        	while (true) {	
	            	if(serverOutput.equals(null)){
						try {
							System.out.println(br.readLine());
							Thread.sleep(5000);
						} catch ( Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}
	            }
	        };
	        
	        
	        
	        Runnable clientSide = () -> 
	        {
	        	String userInput = "";
	            while (true) {	
	            	try {
						userInput = brIn.readLine();
						Thread.sleep(5000);
					} catch (IOException | InterruptedException e)  {
						e.printStackTrace();
					}
				    ps.println(userInput);
	            }
	        };
	        
	        
	        
	        Thread clientSideThread = new Thread(clientSide);
	        Thread chatLogThread = new Thread(chatLog);
	        
	        clientSideThread.start();
	        chatLogThread.start();
	        
		 
        }
    }
}







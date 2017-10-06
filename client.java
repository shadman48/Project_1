
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

    public static void main(String[] args) throws Exception {
        
    	try (Socket socket = new Socket("18.221.102.182", 38001)) 
        {
			String username = "Shadman48";
			//Send user name.
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			//DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os, true, "UTF-8");
			ps.println(username);
			
			
		
       	
        	
        	//Receive response from server.
			BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
			String serverOutput = br.readLine();
				
			Runnable chatLog = () -> 
	        {
	        	String serverOutputOld = "";
	            while (true) 
	            {	
	            	try
	            	{
	            		if(serverOutput != null)
	            	   	{
	            			System.out.println(br.readLine());
	               	   	}
	            	}
	            	catch (Exception e)
	            	{
	            		return;
	            	}
	            	
	            }
	        };
	        
	        
	        
	        Runnable clientSide = () -> 
	        {
	        	String userInput = "";
	            while (true) {	
						try {
							userInput = brIn.readLine();
							ps.println(userInput);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							return;
						}
					
				   
	            }
	        };
	        
	        
	        
	        
	        Thread clientSideThread = new Thread(clientSide);
	        Thread chatLogThread = new Thread(chatLog);
	        chatLogThread.start();
			clientSideThread.start();
		 
			
			while (true)
			{
				Thread.sleep(1000);
			}
        }
    }
}







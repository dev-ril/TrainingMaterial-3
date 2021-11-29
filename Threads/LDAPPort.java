//	6. Write a program to check whether a port(eg.  LDAP port) is opened or not.

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

class LDAPPort
{
	public static boolean isPortAvailable(int port) 
	{
		boolean isAlive = false;
    	try
    	{
 			Socket socket = new Socket("localhost", port); //Creates connection with the specified port on the host...
    	    isAlive = true; //If it is available for connection, then the above operation is possible..
    	} 
    	catch(SocketException se)
    	{
    		se.printStackTrace();	
    	}
    	catch(IOException ie)
    	{
    		ie.printStackTrace();
    	}

    	return isAlive;
	}

	public static void main(String[] args) 
	{
		if(isPortAvailable(389)) //Currently closed
		{
			System.out.println("Port is available");
		}	
		else
		{
			System.out.println("Port is not available");
		}
	}
}
//	7. Write a program to resolve the host name of PC, if IP is provided

import java.net.InetAddress;  // This class provides methods to get the IP of any host name

class IPAddress
{
	public static void main(String[] args) 
	{
		try
		{
			InetAddress ip = InetAddress.getByName("192.168.1.101"); // getByName() method returns the instance of InetAddress containing LocalHost IP and name.

			System.out.println("HostName: " + ip.getHostName()); // getHostName() method of the InetAddress class returns the host name of the given IP address.
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
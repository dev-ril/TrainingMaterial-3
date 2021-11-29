//	10. Write a program to open Internet Explorer from java without addons

import java.util.*;

class InternetExplorer
{
	public static void main(String[] args) 
	{
		try	
		{
		Process process = Runtime.getRuntime();.exec("cmd /c start iexplore -extoff");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
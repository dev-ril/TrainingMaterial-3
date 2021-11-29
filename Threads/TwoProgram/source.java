//	8. Write a program which will run another java program (you will have to invoke the "java xyz" from this program!) get the output of the program and print it to a file.

import java.io.*;

//import java.io.Exception;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.FileWriter;

class source
{
	public static void main(String[] args) 
	{
		try
		{
			Process p1 = Runtime.getRuntime().exec("javac --release 8 xyz.java"); //The exec() method of getRuntime() method of the Runtime class executes the given command in separate process 
			Process p2 = Runtime.getRuntime().exec("java xyz");

			InputStream is = p2.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int c;
			String output = "";

			while((c=isr.read()) != -1)
			{
				output+=(char)c;
			}

			FileWriter target = new FileWriter("xyz.txt");
			target.write(output);
			target.close();			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
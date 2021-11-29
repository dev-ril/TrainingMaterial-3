//	9. Write a program which will run your string reverse java program (you will have to invoke the "java Reverse" from this program!) give the input to the Reverse program from this program and get the output and print the output to a file.

import java.io.*;
import java.util.*;

//import java.io.Exception;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.FileWriter;

class reverseSource
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to reverse:");
		String str = sc.nextLine();
		System.out.println();

		try
		{
			Process p1 = Runtime.getRuntime().exec("javac --release 8 reverseDestination.java"); //The exec() method executes the given command in separate process..
			Process p2 = Runtime.getRuntime().exec("java reverseDestination "+str); // We can pass in the arguments to that program in the command-line itself..

			InputStream is = p2.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int c;
			String output = "";

			while((c=isr.read()) != -1)
			{
				output+=(char)c;
			}

			FileWriter target = new FileWriter("reverse.txt");
			target.write(output);
			target.close();	
				
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
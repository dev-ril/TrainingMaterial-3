//	9. Write a program which will run your string reverse java program (you will have to invoke the "java Reverse" from this program!) give the input to the Reverse program from this program and get the output and print the output to a file.

class reverseDestination
{
	public static void main(String[] args) 
	{
		String str = "";
		for(String s:args)
		{
			str+=s;
		}

		StringBuffer sb = new StringBuffer(str);
		sb.reverse();

		System.out.println("Reversed string:\n" + sb);
	}
}
//	6. Create a java method "Print" which accepts a hashmap and prints the value. Next create a java hashmap object from c++ code and populate with environmental values. Call the java method Print from c++. (Create a dll and invoke dll from java main method)

import java.util.*;

public class JavaJNI
{

	/*static 
	{
		
	}*/

	public static void main(String[] args) 
	{
		System.loadLibrary("javajni");	//invoke the dll file created...

		new JavaJNI().callback();
	}

	public native void callback(); //Native code call

	public static void print(HashMap<String, String> hashMap) //Method to be called from the Native C++ code
	{
		System.out.println("Received HashMap from C++ Native Code...\n");
		for(Map.Entry m: hashMap.entrySet())
		{
			System.out.println(m.getKey()+ " "+m.getValue());
		}
	}
}

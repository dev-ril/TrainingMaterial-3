//  6. Create a java method "Print" which accepts a hashmap and prints the value. Next create a java hashmap object from c++ code and populate with environmental values. Call the java method Print from c++. (Create a dll and invoke dll from java main method)

#include <stdio.h>
#include <cstdlib>
#include <jni.h>
#include "JavaJNI.h"

using namespace std;

JNIEXPORT void JNICALL Java_JavaJNI_callback(JNIEnv *env, jobject jthis) 
{
	   jclass mapClass = env->FindClass("java/util/HashMap"); // Getting the HashMap class from the java.util package
           if(mapClass == NULL)
           {
               printf("Error occurred in finding the HashMap");
           }    
	
           jsize map_len = 3;
	
           jmethodID init = env->GetMethodID(mapClass, "<init>", "(I)V"); //Obtaining the constructor of the HashMap class

           jobject hashMap = env->NewObject(mapClass, init, map_len); //Creating a HashMap object with size map_len...

           jmethodID put = env->GetMethodID(mapClass, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"); // getting the methodID for the put method of the hashmap

           env->CallObjectMethod(hashMap, put, env->NewStringUTF("JAVA_HOME"),env->NewStringUTF(getenv("JAVA_HOME")));  // Populating environmental values into the hashmap using the created instance..

           env->CallObjectMethod(hashMap, put, env->NewStringUTF("JRE_HOME"),env->NewStringUTF(getenv("JRE_HOME")));

           env->CallObjectMethod(hashMap, put, env->NewStringUTF("OS"),env->NewStringUTF(getenv("OS")));

	
    	   jclass thisClass = env->GetObjectClass(jthis); // Getting the java class using the object of the java class

    	   jmethodID printHashMap = env->GetStaticMethodID(thisClass, "print", "(Ljava/util/HashMap;)V"); // getting the methodID for the method print by using the class name as it is a static method

    	   if (printHashMap == NULL) //Checking whether the methodID is obtained or not
    	   {
    		printf("Error occurred in getting MethodID");
           }
        
    	   env->CallVoidMethod(jthis,printHashMap, hashMap); //Calling the java method print from c++...
}

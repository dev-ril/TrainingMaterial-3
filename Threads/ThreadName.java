import java.lang.Thread;
import java.lang.Runnable;

// By directly creating instance of the Thread class..

class ThreadName
{
	public void run()
	{
		System.out.println("The thread t1 started..");
	}

	public static void main(String[] args) 
	{
			Thread t1 = new Thread();
			Thread t2 = new Thread("thread2");

			String str1 = t1.getName();

			System.out.println("The thread name is " + str1);

			String str2 = t2.getName();

			System.out.println("The thread name is " + str2);

			t1.setName("thread1");

			String str = t1.getName();

			System.out.println("The thread name is " + str);

			Thread2.main();

			Thread3.main();

	}
}

// By extending the Thread class...

class Thread2 extends Thread
{
	public void run()
	{
		System.out.println("The thread t2 started..");
	}


	public static void main()
	{
		Thread2 t2 = new Thread2();

		t2.start();
	}

}

// By implementing the Runnable interface....

class Thread3 implements Runnable
{
	public static void main()
	{
		Thread3 th3 = new Thread3();
		Thread t3 = new Thread(th3);	
		t3.start();
	}

	public void run()
	{
		System.out.println("The thread t3 started..");
	}
}
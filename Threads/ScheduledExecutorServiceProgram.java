/*
	11. Learn concurrent package in java. Write programs to use the following classes,
    ExecutorService, ThreadPoolExecutor, ScheduledExecutorService, Future, Callable
*/

import java.util.concurrent.*;

class ScheduledExecutorServiceProgram extends Exception
{
	public static void main(String[] args) 
	{
		try
		{
		ScheduledExecutorService service3 = Executors.newScheduledThreadPool(10); //create a thread pool of size n , in which we can schedule the execution of threads

		service3.schedule(new Task(), 10, TimeUnit.SECONDS); //tasks runs after 10 seconds delay..

		service3.scheduleAtFixedRate(new Task(), 15,  10, TimeUnit.SECONDS); //tasks runs repeatedly every 10 seconds..

		service3.shutdown(); // It initiates shutdown of the thread pool and completes all the pending tasks.No other tasks can be executed after shutting down..
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());	

	}
}

class Task implements Runnable
{
	public void run()
	{
		System.out.println("Thread Name: " + Thread.currentThread().getName());
	}
}
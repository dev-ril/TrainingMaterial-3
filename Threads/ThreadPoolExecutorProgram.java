/*
	11. Learn concurrent package in java. Write programs to use the following classes,
    ExecutorService, ThreadPoolExecutor, ScheduledExecutorService, Future, Callable
*/

import java.util.concurrent.*;

class ThreadPoolExecutorProgram extends Exception
{
	public static void main(String[] args) 
	{
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();	

		System.out.println("Largest executions: " + executor.getLargestPoolSize());
      	System.out.println("Maximum allowed threads: " + executor.getMaximumPoolSize());
      	System.out.println("Current threads in pool: " + executor.getPoolSize());
      	System.out.println("Currently executing threads: " + executor.getActiveCount());
      	System.out.println("Total number of threads(ever scheduled): " + executor.getTaskCount() +"\n");
      	for(int i=0;i<5;i++)
      	{
      		executor.submit(new Task());
      	}
      	
      	System.out.println("\nLargest executions: " + executor.getLargestPoolSize());
      	System.out.println("Maximum allowed threads: " + executor.getMaximumPoolSize());
      	System.out.println("Current threads in pool: " + executor.getPoolSize());
      	System.out.println("Currently executing threads: " + executor.getActiveCount());
      	System.out.println("Total number of threads(ever scheduled): " + executor.getTaskCount());

      	executor.shutdown();

	}
}

class Task implements Runnable
{
	public void run()
	{
		System.out.println("Thread Name: " + Thread.currentThread().getName());
	}
}
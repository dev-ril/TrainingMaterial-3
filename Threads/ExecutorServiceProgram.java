/*
	11. Learn concurrent package in java. Write programs to use the following classes,
    ExecutorService, ThreadPoolExecutor, ScheduledExecutorService, Future, Callable
*/


import java.util.concurrent.*; //ExecutorService interface is present in the concurrent package..

class ExecutorServiceProgram
{
	public static void main(String[] args) 
	{
		System.out.println("Fixed Thread Pool");

		ExecutorService service1 =  Executors.newFixedThreadPool(10); //Create a thread pool of fixed size n with n - threads..

		for(int i = 0; i < 25; i++) //Assigning 25 tasks which will be done by the threads...
		{
			service1.execute(new Task()); //Assign a task to any of the thread available in the thread pool...
		}

		service1.shutdown(); // It initiates shutdown of the thread pool and completes all the pending tasks.No other tasks can be executed after shutting down..

		System.out.println("\nCached Thread Pool");

		ExecutorService service2 = Executors.newCachedThreadPool(); //Create a thread pool,with number of threads based on the requirement..

		for(int i = 0; i < 25; i++) //Assigning 25 tasks which will be done by the threads...
		{
			service2.execute(new Task()); //Assign a task to any of the thread available in the thread pool...
		}

		service2.shutdown();

	}
}

class Task implements Runnable
{
	public void run()
	{
		System.out.println("Thread name: " + Thread.currentThread().getName());
	}
}
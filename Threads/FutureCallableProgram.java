/*
	11. Learn concurrent package in java. Write programs to use the following classes,
    ExecutorService, ThreadPoolExecutor, ScheduledExecutorService, Future, Callable
*/


import java.util.concurrent.*;
import java.util.*;

@SuppressWarnings("unchecked")
class FutureCallableProgram
{
	public static void main(String[] args) throws Exception
	{
		ExecutorService service = Executors.newFixedThreadPool(3);

		List<Future> futurelist = new ArrayList<Future>();

		for(int i=0;i<5;i++)
		{
			Future<Integer> future = service.submit(new Task());
			futurelist.add(future);
		}
		
		for(int i=0;i<5;i++)
		{
			Future<Integer> future = futurelist.get(i);
			Integer result = future.get();
			System.out.println("Result of the future " + i + " is " + result);
		}
		service.shutdown();
	}
}

class Task implements Callable<Integer>
{
	public Integer call() throws Exception
	{
		Thread.sleep(2000);
		Random random = new Random();
		System.out.println("thread name: " + Thread.currentThread().getName());
		return random.nextInt();
	}
}
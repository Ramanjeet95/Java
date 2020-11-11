package threads;

/*
 * There are many ways by which we can pause or temporarily stop the execution of a thread.
 * Some of these are -
 * 
 * 1. yield()
 * 2. join()
 * 3. sleep()
 * 
 * yield() - yield() method provides A hint to the scheduler that the current thread is willing to yield
 * its current use of a processor. The scheduler is free to ignore this hint. It causes the thread to move 
 * back to ready/runnable state. It gives chance to other high priority threads to execute. We can not determine
 * when the thread that yielded will get a chance to run again.Its a static method in Thread class. It written in 
 * native code. Depending upon the OS it may or may not work. Thread.yield() does not throw a checked exception.    
 * 
 * join() - join() method causes the thread to go in waiting/blocked stage. join() method is useful in cases where 
 * one thread is dependent on the output of another thread and has to wait for it to finish before it can start executing.
 * Thread that calls join() method goes into waiting state but thread on which join() is called has no idea and continues
 * its execution and when it finishes the waiting thread resumes. The waiting thread does not directly go in running state,
 * when thread resumes its goes to ready/runnable state and has to wait for scheduler to pick it.
 * 
 * e.g. t.join(); 
 * 
 * join() method throws InterruptedException which is checked exception so it needs to be handled. join is implemented in java
 * and its not a native method and its final and an instance method.
 * 
 * There are 3 variants of join method, one no arg and other takes milliseconds as parameter. Thread waits for the other thread 
 * to finish for the specified amount of time, if the thread does not finish by then, waiting thread will start executing.
 * 
 * sleep() - sleep() method causes thread to go in sleeping state for a specified amount of time. Unlike yield() which causes the 
 * current thread to go in ready/runnable state for other waiting threads of same or higher priority to get a chance at execution, 
 * sleep stops the execution temporarily. When sleep is called, CPU is idle unlike yield() which allocates CPU t other threads. 
 * sleep() is also static and  
 * 
 * We should use yield() when current thread is not doing something important and its ok for it to give other threads a chance to 
 * execute. join() is used when a thread needs to wait for another thread to finish execution, before it can start executing and 
 * sleep() is used when there is requirement to wait for a specific amount of time.  
 */
public class JoinAndYield
{
	public static void main(String[] args) throws InterruptedException 
	{
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
			{
				System.out.println(Thread.currentThread().getName());
				Thread.yield();
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});//.start();
		

		for (int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName());
		}
		
		Thread t = new Thread(()->
		{
			for (int i = 0; i < 10; i++)
			{
				System.out.println(Thread.currentThread().getName());
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		t.start();
		t.join();
		for (int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName());
		}
	}
}

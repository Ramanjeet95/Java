package threads;
/*
 * In java one thread can interrupt another sleeping  or waiting thread. When one thread calls
 * interrupt on another thread the waiting thread throws InterruptedException. If thread is not 
 * in sleeping or waiting thread and in running state then the interrupt call does not have any 
 * effect until the thread goes to sleep or in waiting state. When the thread on which interrupt()
 * is called goes to sleep immediately it throws InterruptedException.
 * 
 * A thread can be interrupted by calling interrupt() method on it.
 * 
 * e.g 	t1.interrupt();
 * 
 * 
 */
public class ThreadInterruption 
{
	public static void main(String[] args)
	{
		Thread t = new Thread(() -> 
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.println("Hello, I am " + Thread.currentThread().getName());
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					System.out.println("I was Interrupted");
				}
			}
		});
		t.start();
		t.interrupt();
	}
}

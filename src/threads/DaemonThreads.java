package threads;
/*
 * Daemon thread are low priority threads that run in background. There purpose is to support non daemon
 * threads. There priority is low usually but it can be high as well e.g garbage collector usually runs with low
 * priority but if jvm runs out of memory, jvm increases its priority and once memory is free it reduces its priority.
 * Garbage collector and signal dispatcher are examples of daemon threads. Daemon threads only exist as long as a non 
 * daemon thread is alive, as soon as all non daemon threads finish, all daemon threads are terminated automatically.
 * 
 * We can check if a thread is daemon thread by calling isDaemon() method. We can also set a thread as daemon thread by 
 * calling setDaemon(Boolean isDaemon) method. A thread can only be set as daemon thread before it is started, calling 
 * setDaemon(true) on a thread after it is started will result in IllegalThreadStateException.
 * By default main thread is non daemon and since it is started by jvm, we can not change main thread to daemon thread.
 * A thread which is started by a daemon thread will also be daemon thread and vice versa.  
 */


public class DaemonThreads 
{
	public static void main(String[] args) throws InterruptedException 
	{
	Thread daemonThread = new Thread(()->
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("daemon executing...");
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}); 
	daemonThread.setDaemon(true);
	daemonThread.start();
	Thread.sleep(5000);
	System.out.println("Main thread finished");
	}
}

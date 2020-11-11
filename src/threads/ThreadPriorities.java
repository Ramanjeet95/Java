package threads;
/*
 * Thread priority is an important concept in threads. Thread priority decides the order of of 
 * execution on threads. Thread scheduler decides which thread to execute next based on there priorities.
 * High priority threads will get precedence over low priority threads. If there are multiple threads with same 
 * priorities, we can not predict which will be executed next. It varies from jvm to jvm.
 * 
 * Thread priority can range from 1 to 10. With 1 being the minimum priority and 10being the maximum priority.
 * If we try to set a priority for a thread outside this 1 to 10 range there will be an IllegalArgumentException.
 * 
 *  We can the get and set the priority of current thread by using static method Thread.currentThread()
 *  
 *  e.g Thread.currentThread().setPiority(1);
 *		Thread.currentThread().getPiority();
 *
 * Default priority of 'main' thread is 5. 
 * Priority is inherited from parent thread to child thread. Here parent thread is the thread that creates and starts
 * the child thread. If the priority of parent thread is 5 then priority of any thread it creates will also be 5 unless 
 * changed explicitly.
 * 
 * Concept of thread priorities also depends upon the platform or OS being used. There are some platform that do not provide
 * support for thread priority i.e setting priority will not have any impact on execution of threads, they will execute as if 
 * there priority was same if the platform does not provide support for thread priorities. 
 */

public class ThreadPriorities 
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 10; i++) 
				System.out.println("thread " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
		});
		
		Thread t2 = new Thread(() -> 
		{
			for(int i = 0; i < 10; i++) 
				System.out.println("thread " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
		});
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
	}
}

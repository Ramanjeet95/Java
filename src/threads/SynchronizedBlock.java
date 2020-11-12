package threads;
/*
 * There are two ways to achieve synchronization in java. We can use synchronized keyword with 
 * methods and blocks. Synchronization can be really useful but at the same time, if not used 
 * correctly, it can greatly reduce program's performance. Let's say there is a method that has 
 * thousand's of lines of code. Around 10-15 lines of this method needs synchronization. If we apply
 * synchronized to the entire method then performance will be greatly affected as only one method will
 * be able to call the method at a time. This is not a good programming practice.
 * 
 * So, instead of making the entire method synchronized, we can synchronize some specific part of the 
 * method that needs synchronization by using a synchronized block. 
 * 				
 * synchronized(this){...}
 * 
 * Only the statements inside synchronized block will be executed by one thread at a time and the rest 
 * of the method can be executed in parallel by multiple threads. Synchronized block takes an object as
 * parameter, this object's lock is acquired by the thread for executing the method. synchronized blocks 
 * can be nested as well with different objects provided as arguments.
 * 
 * e.g
 * 			synchronized(a)
 * 			{
 * 				synchronized(b){..}
 * 			}
 * 
 * Primitives can not be used in synchronized block's parameter because they do not have locks. Only objects
 * are allowed.
 * 
 */

class SharedClass
{
	public void m1()
	{
		String s = "string";
		synchronized(this)
		{
			System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock of sharedClass");
			synchronized(s)
			{
				System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock of string");
				for(int i = 0; i < 5; i++)
				{
					System.out.println("m1() called by " + Thread.currentThread().getName());
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) { }
				}
				System.out.println("Thread " + Thread.currentThread().getName() + " released the lock of string.");
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " released the lock of sharedClass object.");
		}
	}
	
	public void m2()
	{
		synchronized(this)
		{
			System.out.println("m2() called by " + Thread.currentThread().getName());
		}
	}
	
}
public class SynchronizedBlock
{
	public static void main(String[] args) 
	{
		SharedClass sharedClass = new SharedClass();
		new Thread(()->
		{
			sharedClass.m1();						//sharedClass must be final or effectively final
		}).start();
		
		new Thread(()->
		{
			sharedClass.m1();						//sharedClass must be final or effectively final
		}).start();
	}
}

package threads;

/* Synchronization is arguably one of the most valuable concepts of multithreading. If multiple threads are accessing
 * and manipulating the same object, there is a chance of data inconsistency. Data inconsistency can be a major problem.
 * Synchronization is the process of making sure only one thread can access/update a shared resource at a time. In java we
 * we have synchronized keyword to deal with this problem.
 * 
 * synchronized keyword can be used with methods and blocks, it can not be used with classes, interfaces or variables. In java
 * synchronization is implemented using the concept of 'lock' or 'monitor'. Whenever a thread tries to execute a synchronized method
 * of an object, it first need to acquire the lock of the object. If the lock is free then the thread can acquire it and execute the 
 * method. However, if some other thread already has the lock then the current thread has to wait for the lock to be free even if it is trying 
 * to execute a different synchronized method, and goes into blocked or waiting state. Once the currently executing thread finishes it releases
 * the lock and the waiting thread can acquire it and execute the method. To sum it up any time any thread has to execute a synchronized method
 * on any object, first it has to acquire the lock. Every object in java has a lock associated with it. 
 * 
 * A thread can acquire multiple locks of different objects as well.
 * 
 * In java there are two types of locks 
 * 
 * 	1. Object level lock
 *  2. Class level lock
 *  
 *  Class level locks are also internally object level lock, they belong to the Class object that belongs to the class itself. A Class object is created for every class.
 *  Object level lock is for instance methods. When a thread tries to execute a static synchronized method then it needs to acquire the class level 
 *  lock. A class level lock is only required for static synchronized methods execution. synchronized instance methods and static synchronized methods
 *  can be executed simultaneously by different threads as instance methods require object level lock and static synchronized methods require class level 
 *  lock. However, if a thread already has the class level lock and is executing a synchronized static method, other threads have to wait for the class level 
 *  lock to be released before they can execute any static synchronized method of the that class. Lock is not required for executing non synchronized methods
 *  so they can be executed parallel to synchronized methods.
 *  
 *  If two different objects of a class are used to call the same synchronized method by two different threads, they will execute simultaneously because both 
 *  threads are acquiring lock of different objects.
 * 
 * 
 */

class Shared
{
	public synchronized void m1()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("m1() called by " + Thread.currentThread().getName());
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	
	public synchronized void m2()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("m2() called by " + Thread.currentThread().getName());
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
}

//needless use of generic class
class Caller<T extends Shared> extends Thread
{
	private T t;
	Caller(T t, String name)
	{
		super(name);
		this.t = t;
	}
	
	public void run()
	{
		t.m1();
	}
}

public class Synchronization 
{
	public static void main(String[] args)
	{
		Shared s = new Shared();
		Caller<Shared> c1 = new Caller<>(s, "pinky");
		Caller<Shared> c2 = new Caller<>(s, "chinky");
		
		c1.start();
		c2.start();
	}
}

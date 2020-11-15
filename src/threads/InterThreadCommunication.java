package threads;

/*
 * There can be many cases where multiple threads need to communicate with each other. This type of situation 
 * arises when one thread is updating a resource and another threads need to read that resource, the other thread 
 * requires updated values and have to wait for the resource to be updated. In this we need a way for threads to 
 * communicate with each other. 
 * 
 * In java, there are three methods which are used for interthread communication -
 * 
 * 1. wait() throws IE
 * 2. notify()
 * 3. notifyAll()
 * 
 * These methods are methods are present in Object class. This is because these can be called on any object not just thread.
 * A thread can only call these methods if it is the owner of the object and has the lock of the object. If a thread tries to 
 * call any of these methods on an object whose lock it does not have, IllegalMonitorStateException will be thrown at runtime.
 * These methods can only be called from a synchronized area otherwise there will be IllegalMonitorStateException.
 * Except for wait(), notify() and notifyAll() no other method in java releases lock. 
 * 
 * wait() - 
 * 
 * When a thread calls wait() method on an object, it releases the lock of that object immediately and goes into waiting state. If 
 * thread has lock of multiple objects it will only release the lock of that object on which wait() is called and not all locks it has.
 * It will keep waiting until another thread calls notify() or notifyAll() on the same object. When that happens the waiting thread
 * has to first acquire the lock the same object before it can continue executing so it goes into another waiting/blocked state, when
 * it gets the lock it can continue execution. wait() also throws InterruptedException. A thread can only call wait() on an object, if 
 * it has the lock of the object. wait() should be called by a thread that needs to read or access a resource or the consumer thread.
 * If no thread is there to notify(), waiting thread will stay in waiting state forever. wait() method is overloaded and has two more 
 * versions that take number of milliseconds as parameter. If we pass ms as parameter to wait(), it will only wait for that amount of 
 * time and continue execution when time expires. 
 * 
 * notify() -
 * 
 * When a thread calls notify() method on an object, it wakes up one thread that is waiting on that object. Same as wait(), a thread can 
 * only call notify method on an object if it has the lock. notify() must also be called from synchronized area. notify() also releases the 
 * lock of the object on which it is called but unlike wait() it may not release the lock immediately because the thread may have some other 
 * processing to do. If there are multiple threads waiting on an object and notify is called on that object, then only one thread will wake up
 * and we can not predict which thread will wake up. It depends on jvm. notify() does not throw InterruptedException.
 * 
 * notifyAll() -
 * 
 * notifyAll() is almost same as notify() except as the name suggests, it wakes up all the sleeping threads on the object it is called. The sleeping
 * threads wake up at the same time but still have to acquire the lock of the object so they will execute one by one.
 */
class Resource
{
	private int sum;

	public int getSum()
	{
		return sum;
	}

	public void setSum(int sum) 
	{
		this.sum = sum;
	}
}

class MyThread extends Thread
{
	private Resource resource;
	MyThread(Resource resource)
	{
		this.resource = resource;
	}
	public void run()
	{
		System.out.println("In run");
		int sum = 0;
		for(int i = 1; i<=100; i++)
			sum+=i;
		resource.setSum(sum);
		synchronized(resource)
		{
			resource.notify();
			System.out.println("notified");
		}
	}
}

public class InterThreadCommunication
{
	public static void main(String[] args) throws InterruptedException
	{
		Resource resource = new Resource();
		MyThread thread = new MyThread(resource);
		thread.start();
		synchronized(resource)
		{
			resource.wait();
			System.out.println("Waking up");
		}
		System.out.println(resource.getSum());
	}
}

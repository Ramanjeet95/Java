package threads;

/*
 * Deadlock occurs when two thread are waiting on each other and they keep waiting forever.
 * Let's say thread 1 has lock of object a and thread 2 has lock of object b and thread 1 needs to call 
 * a synchronized method on object b and thread 2 has to call a synchronized method on object a. Now,  
 * thread 1 needs lock of object b, which is held by thread 2 and thread2 needs lock of object a, which is 
 * held by thread 1. They are unable to acquire locks and are waiting on each other to release the lock. 
 * Thread1 and Thread 2 are in deadlock because they will keep waiting forever.
 */

class A
{
	synchronized void m1(B b)
	{
		System.out.println("in m1(b) of A");
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		b.m2();
	}
	
	synchronized void m2()
	{
		System.out.println("in m2() of A");
	}
}

class B
{
	synchronized void m1(A a)
	{
		System.out.println("in m1(a) of B");
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		a.m2();
	}
	
	synchronized void m2()
	{
		System.out.println("in m2() of B");
	}
}

//Deadlock demonstration using main thread as second thread
class Thread1 extends Thread
{
	A a  = new A();
	B b  = new B();
	
	public void run()
	{
		a.m1(b);
	}
	
	void startMe()
	{
		this.start();
		b.m1(a);
	}
}
public class Deadlock 
{
	public static void main(String[] args) 
	{
		A a = new A();
		B b = new B();
		//new Thread1().startMe();
		
		//deadlock with two threads, without main thread
		new Thread(() -> a.m1(b)).start();
		new Thread(() -> b.m1(a)).start();
	}
}

package threads;

import java.util.stream.Stream;

/*
 * Thread is one of the most important topics in java language. Before talking about threads
 * lets talk about multitasking. Multitasking means performing multiple tasks simultaneously.
 * 
 * There are two types of multitasking -
 * 
 * Process based multitasking
 * Thread based multitasking
 * 
 * In process based multitasking, task are performed by different processes. There exist multiple 
 * different programs that are executed separately e.g music player, eclipse, browsers. In process based multitasking each process has a
 * separate address space and they completely isolated from one another. Context switching is difficult 
 * in process based multitasking.  
 * 
 * A thread is a light weight process or a separate independent flow of execution. In thread based multitasking, there is only one process. 
 * Threads exist in the same process and share the address space of the process. Context switching is relatively easy in thread based multitasking.
 * In one program, we can have multiple different threads that execute simultaneously and perform different independent tasks. Remember, multithreading 
 * is only useful in case we have independent tasks that can run simultaneously. If there is dependency between tasks, multithreadng is not the way to go.
 * Purpose of multithreading is to reduce idle time of the CPU and increase performance.
 * 
 * Java provides inbuilt support for multithreading. There are two ways to create threads in java.
 * 
 * By extending Thread class
 * By implementing Runnable interface
 * 
 * Creating thread by implementing runnable is the preferred method. This is because if a class extends Thread class, it can not extend
 * any other class, however if a class implements runnable then it can still extend other class as well. Apart from this there are some 
 * performance improvement as well with implementing runnable.
 * 
 * Even when implementing runnable we still have to pass the runnable object to a thread object to actually create a thread. The thread
 * object internally calls the run() method of the runnable instance passed. Thread class also implements runnable so it is possible to pass 
 * a thread object to the thread class constructor. 
 * 
 * run() - Both of these have a run() method which we have to override. The logic which the thread will execute,
 * goes in run() method. run() is called internally by start() method. It is possible overload run method, but start() only
 * call the run method with no args. If we call run() directly without calling start(), it will execute like a normal method and
 * no separate thread will be created.
 * 
 * start() - start() method is very important. A new thread is only created when start is called. start() registers the thread with 
 * the thread scheduler and performs some other mandatory actions. start() also calls the run method. Thread method can also be overridden, however
 * its not recommended because thread will not be created unless we call the Thread class start() method. 
 * 
 * Thread Scheduler is responsible for scheduling of threads. Order of execution is determined by thread scheduler. Thread scheduler is 
 * part of JVM and its implementation varies from jvm to jvm. 
 * 
 * Thread Life cycle - 
 * 
 * Thread has mainly 4 states
 * 
 * 1. new/born
 * 2. ready/runnable
 * 3. running
 * 4. dead
 * 
 * When thread object is created its in new state. 
 * After calling start() it goes to ready state.
 * When thread scheduler picks the thread it goes to running state
 * once run() is complete thread moves to dead state.
 * 
 * Thread can also go in waiting/blocked state.
 * When we call yield() method thread goes back to ready/runnable state.
 * When join method is called thread goes to waiting/blocked state, when the method the waiting thread is waiting
 * on finishes, the waiting thread goes to ready/runnable state and waits for scheduler to pick it.
 * 
 * wait() also pauses the execution of thread.   
 * 
 * We can not call start() on the same thread twice. If we do that here will be IllegalThreadStateException
 * will be thrown at runtime.
 * 
 * Each thread has a name, we can change it as well.We can even change the name of main thread. 
 * Thread.currentThread() returns current thread instance.
 */

class MyRunnable implements Runnable
{
	public void run() 
	{
		System.out.println("my thread");
	}
}

public class Introduction extends Thread 
{
	public void run()
	{
		Stream.of(1,2,3,4,5,6,7,8,9,10).map(x -> "child "+ x).forEach(System.out::println);
	}
	
	public static void main(String[] args) 
	{
		Introduction intro = new Introduction();
		intro.start();
		Stream.of(1,2,3,4,5,6,7,8,9,10).map(x -> "main "+ x).forEach(System.out::println);
		//intro.start();					//runtime error
		
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
	}
}

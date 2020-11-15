package threads;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable
{
	private Queue<String> sharedQueue;
	
	Producer(Queue<String> sharedQueue)
	{
		this.sharedQueue = sharedQueue;
	}
	public void produce() throws InterruptedException
	{
		for(;;)
		{
			synchronized(sharedQueue)
			{
				if(!sharedQueue.isEmpty())
					sharedQueue.wait();
				
				System.out.println("Producing items...");
				for(int i = 0; i < 5; i++)
				{
					sharedQueue.offer("Item"+i);
					Thread.sleep(1000);
				}
				
				sharedQueue.notify();
			}
		}
	}
	
	@Override
	public void run()
	{
		try 
		{
			this.produce();
		} 
		catch (InterruptedException e) 
		{
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
	}
}

class Consumer implements Runnable
{
	private Queue<String> sharedQueue;
	Consumer(Queue<String> sharedQueue)
	{
		this.sharedQueue = sharedQueue;
	}
	public void consume() throws InterruptedException
	{
		for(;;)
		{
			synchronized(sharedQueue)
			{
				if(sharedQueue.isEmpty())
					sharedQueue.wait();
				
				System.out.println("Consuming items...");
				while(!sharedQueue.isEmpty())
				{
					System.out.println("Consumed : " + sharedQueue.poll());
					Thread.sleep(1000);
				}
				
				sharedQueue.notify();
			}
		}
	}
	
	@Override
	public void run()
	{
		try 
		{
			this.consume();
		} 
		catch (InterruptedException e) 
		{
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
	}
}

public class ProducerConsumerProblem 
{
	public static void main(String[] args) 
	{
		Queue<String> queue = new LinkedList<>();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	} 
}

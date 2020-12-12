package threads;

public class TestRunnable implements Runnable
{
	private int count;
	public void run()
	{
		for(int i = 0; i < 1000000; i++)
		{
			synchronized(this)
			{
				count++;
			}
		}
		System.out.println(Thread.currentThread().getName()+ " "+ count);
	}
	
	public static void main(String[] args) {
		Runnable r = new TestRunnable();
		new Thread(r, "Thread 1").start();
		new Thread(r, "Thread 2").start();
	}
}

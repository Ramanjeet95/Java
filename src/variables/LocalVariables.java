package variables;

public class LocalVariables 
{
	int x;
	public LocalVariables(int x) 
	{
		m1(x);
	}
	
	public void m1(int x)
	{
		this.x = 3*x;
	}
	
	public static void main(String[] args)
	{
		int x = 10;
		LocalVariables l = new LocalVariables(10);
		System.out.println(l.x + ":" + x);
	}
}

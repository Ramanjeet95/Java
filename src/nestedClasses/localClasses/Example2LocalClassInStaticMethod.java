package nestedClasses.localClasses;

public class Example2LocalClassInStaticMethod 
{
	private int a = 112;
	private static int b = 121;
	private int i = 34;
	private int k = 121212;
	
	public static void staticMethod()
	{
		int i = 90;
		class LocalClass1
		{
			int j = 1212;
			public void printData()
			{
				System.out.println("local i: " + i);
				//System.out.println("Enclosing i: " + Example2LocalClassInStaticMethod.this.i);         Not accessible
				System.out.println("b : " + b);
				//System.out.println("k ; " + k);                   // Gives error because only statiic members of the enclosing type are accessible for local classes inside static methods
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		staticMethod();
	}
}

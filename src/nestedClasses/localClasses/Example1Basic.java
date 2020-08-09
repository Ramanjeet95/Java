package nestedClasses.localClasses;

public class Example1Basic 
{
	private int x = 10;
	private static int count = 23;
	int a = 12312;
	public void nonStaticMethod()
	{
		int a = 13; 
		x = 12;					// This is fine
		class LocalClass1
		{
			//private int a = 15;
			private int b = 16;
			private String name = "Raman";
			public LocalClass1()
			{
				//a=23;         This will give error as enclosing fields must be effectively final
			}
			public void printData()
			{
				System.out.println("x : " + x);
				System.out.println("a : " + a);
				System.out.println("SuperClass.this.a : " + Example1Basic.this.a);
				System.out.println("b : " + b);
				System.out.println("name : " + name);
				System.out.println(count);
			}
		}
		
		class LocaClass2 extends LocalClass1
		{
			public void helloWorld()
			{
				System.out.println("Hello World");
			}
		}
		
		LocaClass2 lc2 = new LocaClass2();
		lc2.helloWorld();
		lc2.printData();
	}
	
	public static void printCount() 
	{
		System.out.println(count);
	}
	
	public static void main(String[] args) 
	{
		Example1Basic one = new Example1Basic();
		one.nonStaticMethod();
	}
}

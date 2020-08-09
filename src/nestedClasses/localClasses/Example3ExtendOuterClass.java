package nestedClasses.localClasses;

public class Example3ExtendOuterClass
{
	private int x = 10;
	private static int count = 23;
	int a = 12312;
	public void nonStaticMethod()
	{
		int a = 13; 
		x = 12;					// This is fine
		class LocalClass1 extends Example3ExtendOuterClass
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
				System.out.println("SuperClass.this.a : " + Example3ExtendOuterClass.this.a);
				System.out.println("b : " + b);
				System.out.println("name : " + name);
				System.out.println(count);
			}
		}
		
		class LocalClass2
		{
			private int count = 23;
			
		}
		
	}
}

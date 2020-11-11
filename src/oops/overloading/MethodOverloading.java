package oops.overloading;

/*
 * Method overloading is the concept of having multiple methods with same name but different
 * prototypes or argument list. Arguments number, type and order can be different.
 * 
 * we can also have some static and some instance methods with same name.
 * 
 * Method can not be overloaded by changing return types.
 * 
 * Method overloading comes under compile time polymorphism or static binding whereas method overriding
 * comes under runtime polymorphism.
 * 
 * If method with same args type is not present then compiler will call the method with next higher arg type 
 * in the same family. If a method with same family arg type parameters does not exist then it goes to method with
 * parameter that are compatible e.g. passing integers will call method with double as parameters. After that priority 
 * will be given to var-args.
 * 
 *  
 * Method with var-args as parameter will be given last priority by the compiler.
 * 
 * Compiler will not assign the call to overridden method if it takes Integer and you are passing in byte.
 * 
 */
public class MethodOverloading
{
	public static int add(int a, int b)
	{
		System.out.println("int add");
		return a+b;
	}
	
	public static  Integer add(Integer a, Integer b)
	{
		System.out.println("Integer add");
		return a+b;
	}
	
	public static double add(double a, double b)
	{
		System.out.println("Integer add");
		return a+b;
	}
	
	public static int add(short a, int b)
	{
		System.out.println("short and int add");
		return a+b;
	}
	
	public static int add(short a, short b)
	{
		System.out.println("short add");
		return a+b;
	}
	
	public static int add(byte a, byte b)
	{
		System.out.println("byte add");
		return a+b;
	}
	
	public static int add(byte... b)
	{
		System.out.println("byte var arg add");
		int sum = 0;
		for(int i = 0; i < b.length; i++)
		{
			sum = sum + b[i];
		}
		return sum;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(add());			//possible to call a var-arg method with no params
		byte a = 1;
		byte b = 2;
		short c = 3;
		short d = 4;
		int e = 5;
		int f = 6;
		System.out.println(add(a,b));
	}
}

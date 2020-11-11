package oops.inheritance;

/*
 * Multilevel inheritance is the concept when a subclass inherits from a base class
 * and in turn that subclass is also a base class for another class that inherits from it.
 * 
 * In multilevel inheritance a class can directly access the grand parent's public members.
 * However, if child and parent class override the grand parents methods in that case child class
 * can not directly access the grand parent class's version of the method. Parent class's members can 
 * be accessed by super. 
 */

class First
{
	int a;
	int b;
	int same;
	public void printHello()
	{
		System.out.println("hello");
	}
}

class Second extends First
{
	int c;
	int same;
	public void printHello()
	{
		System.out.println("hello");
	}
	public void printWorld()
	{
		System.out.println("World");
	}
}

public class Multilevel extends Second
{
	public static void main(String[] args) 
	{
		Multilevel m = new Multilevel();
		System.out.println(m.a);
		System.out.println(m.b);				//First's b
		System.out.println(m.same);				//Second's same
	}
}

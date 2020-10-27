package java8;

/*
 * Before 1.8 interfaces were not allowed to have concrete methods.
 * 1.8 onwards interfaces are allowed to have default and static methods.
 * 
 * All methods in an interface are by default public and abstract.
 * All variables in an interface are by default public static final.
 * 
 * 1.9 onwards interfaces are also allowed to have private methods.
 * 
 * Default methods were introduced to extends the functionality of interfaces without 
 * breaking existing implementation classes.
 * 
 * Default methods are also called VIRTUAL EXTENSION METHODS and DEFENDER METHODS.
 * Default methods are by default available to implementation classes and they can be 
 * overridden in child classes.
 * 
 * If a class implements two interfaces which contain a method with same name then we can access
 * the specific methods as follows
 * 
 * 		Interf1.super.m1();
 * 		Interf2.super.m1();
 * 
 * Any Object class method can not be overridden in an interface, because purpose of default
 * methods is for it to be available to the implementing class and all the Object class
 * methods are already available in every class. 
 * 
 * If a class only contains static methods, these methods should be put in an interface instead.
 * 
 * Java does not support multiple inheritance. However it is possible for a class/interface to 
 * implement/extend more than one interfaces.
 * 
 * If two or more interfaces have a default method with same name, its implementation must be 
 * provided in the implementation class.
 * 
 * Static methods are by default not available in the implementation classes, they must be 
 * called using interface name.
 * 
 * 1.8 onwards we can define main method in an interface as well and we can use it to run the code.
 */
interface A
{
	default int sum(int a, int b)
	{
		return a+b;
	}
	
	static int multiply(int a, int b)
	{
		return a*b;
	}
}

interface B
{
	default int sum(int a, int b)
	{
		return a+b;
	}
}
interface C extends A,B
{

	@Override
	default int sum(int a, int b) 		//must implement the common method in parent Interfaces
	{
		return A.super.sum(a, b);		
	}
	
}

class temp implements A, B
{
	@Override
	public int sum(int a, int b) 		//must implement the common method in parent Interfaces
	{
		return A.super.sum(a, b);		
	}
}

public class DefaultAndStaticMethods implements A
{
	void m1()
	{
		sum(1,2);				//default method sum directly accessible 
		//multiply(2, 2);			//static method multiply not directly accessible
		A.multiply(2, 2);		//now accessible with Interface name
	}
}

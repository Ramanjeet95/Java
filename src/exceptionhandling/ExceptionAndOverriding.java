package exceptionhandling;

import java.sql.SQLException;

/*
 * There are some rules that we have to follow while overriding a method that throws
 * an exception or while declaring exception in the overridden method.
 * 
 * If the overridden method in parent class does not throw exception then in the subclass
 * it can only throw unchecked exceptions.
 * 
 * If the overridden method in the parent class throws an exception then in the sub class it
 * can only throw the same exception or a child of that exception. It is not allowed to throw a 
 * broader category of exception in the child class for overridden methods.
 * 
 * If overridden method throws an exception then in the subclass that method can be declared with
 * no exception.
 */
class Parent
{
	public void m1()
	{
		System.out.println("No Exception");
	}
	
	public void m2() throws Exception
	{
		System.out.println("throws Exception");
		throw new Exception();
	}
	
	public void m3() throws Exception
	{
		System.out.println("throws Exception");
	}
}
public class ExceptionAndOverriding extends Parent
{
	public void m1() throws ArithmeticException		//can only throw unchecked exceptions
	{
		System.out.println("No Exception");
	}
	
	public void m2()								//no need to throw exception
	{
		System.out.println("does not throw Exception");
	}
	
	public void m3() throws ArithmeticException, NullPointerException		//can declare any subtype of exception declared in parent
	{
		System.out.println("throws Exception");
	}
}

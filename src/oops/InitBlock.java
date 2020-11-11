package oops;

/*
 * Init block are used when we have to execute a piece of code before every constructor
 * invocation. If there are multiple init blocks in a class they are executed in the order they
 * are defined.
 */

class Parent
{
	{
		System.out.println("Parent Init Block1");
	}
	Parent()
	{
		System.out.println("Parent no-arg");
	}
	
	{
		System.out.println("Parent Init Block2");
	}
	
	Parent(int x)
	{
		System.out.println("Parent one arg");
	}
	
}

public class InitBlock extends Parent
{
	{
		System.out.println("Child Init Block1");
	}
	
	public InitBlock() 
	{
		System.out.println("Child no arg");
	}
	
	
	{
		System.out.println("Child Init Block2");
	}
	
	public InitBlock(int x) 
	{
		this();
		System.out.println("Child one arg");
	}
	
	public static void main(String[] args)
	{
		//new InitBlock();
		new InitBlock(2);
	}
}

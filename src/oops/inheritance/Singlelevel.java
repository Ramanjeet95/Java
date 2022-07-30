package oops.inheritance;

/*
 * Inheritance is the concept of oops that lets one class inherit 
 * the properties(fields and methods) of another class. 
 * 
 * Subclass inherits all the public members of the super class.
 * It inherits all the default members as well if both base class 
 * and subclass are in same package and also inherits the protected
 * members even if they are in different packages but private members 
 * are not inherited.
 * 
 * Constructor of parent class must be called by the subclass when subclass
 * is instantiated. 
 * 
 * If parent class does not define a no-arg constructor explicitly, compiler 
 * provides a public no-arg constructor by default. But, if we define a constructor
 * with at least one arg then compiler will not provide a default constructor.
 * In this case the subclass must provide a constructor explicitly and call the 
 * parent class constructor through super otherwise there will be a compiled time error.
 *  
 *   
 * When child class is instantiated, the methods and fields of the parent class are 
 * allocated memory in the child class's object. Important thing to note is that even 
 * though the parent class constructor is also called, no separate object is created 
 * for parent class.
 * 
 * A nested class can access the members of its nesting class.
 * 
 * Every class except Object, which does not extend from another class explicitly, has exactly one
 * superclass. This is because java does not support multiple inheritance with classes.
 * Multiple inheritance is possible with interfaces.
 * 
 * A subclass inherits all the members of a super class(fields, methods, nested classes)
 * except constructors. Constructors are not members they can't be inherited. Parent
 * class constructor can be invoked from child class.
 * 
 *  A subclass does not inherit the private members of its parent class. However, if the 
 *  superclass has public or protected methods(like getters and setters) for accessing its 
 *  private fields, these can also be used by the subclass.
 *  
 *  The inherited fields can be used directly, just like any other fields.
 *  
 *	We can declare new fields in the subclass that are not in the superclass.
 *	
 *  The inherited methods can be used directly as they are.
 *  
 *	We can write a new instance method in the subclass that has the same signature as the one 
 *  in the superclass, thus overriding it.
 *  
 *	We can write a new static method in the subclass that has the same signature as the one in 
 *  the superclass, thus hiding it.
 *  
 *	We can declare new methods in the subclass that are not in the superclass.
 *
 *	We can write a subclass constructor that invokes the constructor of the superclass, either 
 *  implicitly or by using the keyword super.
 */

class Base
{
	private int a;
	private int b;
	
	public Base(int a, int b) 
	{
		this.a = a;
		this.b = b;
	}

	public void printHello()
	{
		System.out.println("Hello");
	}
}

public class Singlelevel extends Base
{
	private int c;
	
	//Singlelevel(){}								//not valid, parent does not have a no-arg constructor
	public Singlelevel(int a, int b, int c) 
	{
		super(a, b);
		this.c = c;
	}
	
	public static void main(String[] args)
	{
		Singlelevel s = new Singlelevel(1, 2, 3);
	}
	
}

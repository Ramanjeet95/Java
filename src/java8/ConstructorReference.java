package java8;

/*
 * We can pass constructor reference as well just like method reference. Constructor reference
 * is passed with following syntax.
 * 
 * e.g		ClassName::new
 * 
 * For passing constructor reference to a functional interface, the number of parameters in constructor 
 * and functional interface's method must match and the type should be compatible.
 * If there are multiple constructors in a class then the constructor whose parameters match the abstract
 * methods parameter list will be passed as reference. If there are no constructors matching parameter list of 
 * the abstract method in functional interface, compilation will fail. 
 * 
 * Parameter type of constructor args should be bigger than the abstract methods parameter type or there will
 * be a compilation error.
 * 
 * Return type of abstract method can be void, class that constructor belongs to or a parent of the class that 
 * constructor belongs to.
 * 
 * If the constructor being passed as reference throws an exception then the functional interface's method must 
 * throw the same exception or its parent type.
 */

class General{}

class Person extends General
{
	int id;
	
	String name;
	
	Person(){}
	
	Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	Person(Person p)
	{
		this.id = p.id;
		this.name = p.name;
	}
}

interface Actor
{
	General getActor(int id, String name);
}

interface Doctor
{
	void getDoctor(int id, String name);
}

interface Engineer
{
	Person getEngineer(short id, String name);
}

public class ConstructorReference 
{
	public static void main(String[] args) 
	{
		Actor actor = Person::new;
		Doctor doc = Person::new;
		Engineer eng = Person::new;
	}
}

package java8;

/* Method reference is compact and easy form of lambda expression. It provides code re-usability.
 * Basically, if an existing method needs to be used in a functional interface then its better to use 
 * method reference.
 * 
 * If the code that we need does not exist in that case, lambda expression should be the way to go.
 * 
 * Method reference is passed by using :: operator.
 * 
 *  e.g  Test::sum;
 *  
 * Both static and non static methods can be passed as method references.
 * 
 * In case of static method, use the class name followed by :: operator, followed by method name to pass the reference.
 * 	e.g. Test::sum;
 * 
 * In case of instance method, use and object followed by :: and the method name.
 * 
 * 	e.g new Test()::subtract;
 * 
 * 
 * There will be no compile time error if the method in functional interface, for which you are 
 * providing the method reference, has a void return type and method whose reference is being passed 
 * returns some value.
 * 
 * However, reverse is not true i.e. there will be compilation error if the method in functional interface 
 * has a return type but the method reference being supplied does not return a value.
 * 
 * Method reference can be provided to a functional interface only if the argument number are same and type
 * of arguments is compatible.
 * 
 * Return type of the functional interface's method should be compatible and bigger(i.e implicit cast) than the the return type of the method
 * being passed as method reference.
 * 
 * Parameter type of referenced method should be compatible and bigger(i.e implicit cast) than the parameter types of functional interface's method.
 * 
 * Passing method reference to a functional interface is equivalent to overriding the functional interface's method.
 * 
 * Modifiers are ignored, only parameters and return type need to be compatible.
 * 
 * We can not pass a method that throws an exception, to a functional interface 
 * whose abstract method declares a narrower exception. i.e the functional interface's method must throws a broader
 * exception than the method whose reference is being passed to it.  
 * 
 * If the method being passed as reference throws an exception then the functional interface's method must throw the same exception or its parent type.
 */
interface Hello
{
	void hello() throws Exception;
}
 
interface Addition
{
	int add(int a, int b);
}
public class MethodReference
{
	private void hello() throws Exception
	{
		System.out.println("Hello");
	}
	private long add(int a, int b)
	{
		return a+b;
	}
	
	private int sum(short a, short b)
	{
		return a+b;
	}
	
	private int sum2()
	{
		return 10;
	}
	public static void main(String[] args) 
	{
		Hello hello = new MethodReference()::hello; 																
		//Addition a = new MethodReference()::add; 			//compilation fails, return type of MethodReference.add should be smaller
		//Addition a = new MethodReference()::sum;			//compilation fails, Parameters type for MethodReference.add should be bigger
		Hello hello2 = new MethodReference()::sum2;				//no error, return type of method reference should be smaller or equal
	}
}

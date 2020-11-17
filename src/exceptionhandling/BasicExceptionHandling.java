package exceptionhandling;

import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * We use a try-catch-finally block to handle exceptions in java. Each catch block
 * is an exception handler, it defines what type of exceptions it handles in the brackets.
 * try block can have multiple catch blocks but there can be only one finally block. The code
 * that can throw exception is kept in try block and the corresponding catch block defines the 
 * exception that it can handle. We can have a try-finally block without catch block.
 * 
 * We can not have a catch block that catches a parent exception before a catch block that catches
 * a child exception, compilation will fail. Also we can specify multiple exceptions in a catch block 
 * by separating them with pipe(|) symbol.
 * 
 * e.g 	catch(ArithmeticException|NullPointerException e){} 
 * 
 * We can not specify a parent and child exception separated by pipe(|) symbol, compilation will fail. Also,
 * we can't catch the same exception in two different catch blocks.
 * 
 * e.g 	catch (IOException | FileNotFoundException e) {}
 * In this case,  IOException is parent of FileNotFoundException, compilation will fail.
 * 
 * Introduced in Java 7 – allows us to declare resources to be used in a try block with the assurance that the
 * resources will be closed when after the execution of that block. The resources declared must implement the 
 * AutoCloseable interface. Multiple resources can also be declared in try with resources, they are separated by 
 * semicolon(;).
 * 
 * Resources that were defined/acquired first will be closed last. B
 * Before Java 9, we only could use fresh variables inside a try-with-resources block but after java 9 we can use 
 * final and effectively final variables as well in try with resources.
 * 
 * e.g 
 * 		final Scanner scanner = new Scanner(new File("testRead.txt"));
 * 		PrintWriter writer = new PrintWriter(new File("testWrite.txt"))
 * 		try (scanner;writer) 
 * 		{ 
 *    		// omitted
 * 		}
 */
public class BasicExceptionHandling 
{
	public static void m1() throws FileNotFoundException
	{
		System.out.println("m1()");
	}
	
	public static void m2() throws IOException
	{
		System.out.println("m2()");
	}
	
	public static void main(String[] args) 
	{
		try {
			m1();
			m2();
			
		}
		catch (IOException | ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

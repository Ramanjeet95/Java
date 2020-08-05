package mainMethod;

import java.util.Arrays;
import java.util.stream.Stream;

/*
 * Main Method : Main method in java is the starting point of a program. Execution starts from main method. When we run a java file, following sequence of steps takes place.
 * 				
 * 				 1. JVM is started.
 * 				 2. JVM creates the main thread.
 * 				 3. Main thread loads the class and checks if it has a main method.
 * 				 4. If main method is found, it is executed. Otherwise a runtime exception is thrown.
 * 
 * Signature : 
 * 				 public static void main(String[] args){}
 * 
 * It is not mandatory for java class to have a main method. Main method has a predefined syntax which is known to JVM. 
 * At start up JVM will look for the method with that particular signature. We can modify the signature of the main method but then it will be treated as any other method 
 * and JVM will not be able to use it to start the program. Signature of the main method is very strict. However, some modification are allowed. Some important points about
 * main methods are as follows
 * 
 * 1. public and static are modifiers, in java there is no particular order for modifiers and they can be used in any order 
 * 				 
 * 			static public void main(String[] args){} 			//valid
 * 
 * 2. General flexibility that we have while declaring arrays also applies here as well. Also, name of the array can be anything 
 * 				
 * 			String args[], String []args 						//valid
 * 
 * 3. In java we have var-args syntax which can be used to define that a method takes one or more arguments of a particular type.
 * 	  We can use var-args syntax to declare the argument to the main method.
 * 				
 * 			public static void main(String... args){} 			//valid	
 * 
 * 4. Like any other method in java, we can overload main method as well. But JVM will only call the main with specific syntax.
 * 
 * 5. We can not override main method because in java static methods can't be overridden. However, if we declare the main method in child class
 * 	  as well, it will hide the main method of the parent class.
 * 
 * 6. Principal of inheritance is applicable for main method as well i.e. if child class doesn't declare a main method but the parent class does, 
 * 	  in that case if we try to run child class, main method of the parent class is executed.
 * 
 * 7. main method must be public because its called by jvm and it must be static because it has to be called without an object by JVM.
 * 
 * 8. Along with the necessary modifiers, we can use any combination of the synchronized, final and strictfp modifiers with main method.
 * 
 * 			public final synchronized strictfp static void main(String... args){} 			//valid
 * 
 * 9. The String array parameter that main method receives is for command line args, command line args start from 0 index
 * 	 
 * 10. Space is used as the separator while passing command line args, if there is more than one space between args its ignored by the compiler. 
 * 	   If we have to pass a string as argument which has a space in it we can use double quotes 
 * 	   e.g "Ramanjeet Singh" if we don not enclose it in double quotes, Ramanjeet and Singh will be considered as two separate args.
 * 
 * 11. In java we can cast an array of a child type to an array of its parent type implicitly given that they both have same dimensions.
 * 	   but, if we try to use this while declaring the argument array for main method, it will not be a valid main method.
 * 	   e.g  public static void main(Object[] args){}				//invalid main, valid method
 *  
 * IMPORTANT: javac command is used for compiling .java file and java command is used for running .class file. 
 * 		      e.g 	javac abc.java				java abc
 * 			  It is possible to specify absolute path while compiling java file 
 * 			  e.g   javac C:\temp\abc.java				//valid command
 * 			  But, when running a .class file we cannot provide full path of .class file because java command only expects class name
 * 			  and if we provide full path, entire path is considered as file name and there will be error.
 * 			  e.g  java	C:\temp\abc 					//invalid
 * 			  We can achieve this by changing the class path with -cp to the directory where .class file is present.
 * 			  e.g  java -cp C:\temp\ abc 
 * 			  
 */
public class MainMethodAndCommandlineArgs
{
	//private static void main(String[] args) {}		//invalid main, must be public
	//private void main(String[] args) {}				//invalid main, must be static
	//private static void Main(String... args){}		//invalid main, can't change name
	//public strictfp static final synchronized void main(String[] args) {}			//valid main
	//public static void main(Object[] args) {}			//invalid main, only String array is permitted for arg
	public static void main(String... args)				//valid main
	{
		System.out.println(args.length);
		Stream.of(args).forEach(System.out::println);
		Arrays.stream(args).forEach(System.out::println);
	}	
}

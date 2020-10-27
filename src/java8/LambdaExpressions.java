package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Lambda Expressions -
 * 
 * Lambda expression is an anonymous function. Its purpose is to make the code concise.
 * Lambda expressions and anonymous classes are different. 
 * Anonymous classes are more powerful than lambda expressions 
 * While using lambda expression no separate .class file is generated.
 * Lambda expression can only be used with functional interfaces.
 * 
 * 		e.g () ->{System.out.println("Hello");};
 * 			(String a) -> {System.out.println("Hello" + a);};
 * 
 * Curly braces are not necessary if the body contains only one statement.
 * Input parameter's type does not need to be specified, it can be automatically inferred 
 * by the compiler. 
 * 
 * 		e.g	(a) -> System.out.println("Hello" + a);
 * 
 * If the body only contains one statement, return statement must not be used while returning value.
 * However, return statement is necessary if braces {} are used.
 * 
 * 		e.g (a) -> return a*a;		//invalid	
 * 			(a) -> a*a;				//valid
 * 			(a) -> {return a*a;};	//valid
 * 			(a) -> {a*a;};			//invalid
 * 
 * If there is only one input parameter, parenthesis can also be omitted.
 * 
 * 		e.g a -> a*a;
 * 
 * 
 * Functional Interfaces -
 * 
 * A functional interface is an interface which contains exactly one abstract method.
 * Functional interface can contain multiple default and static methods.
 * @FunctionInterface annotation is used to mark an Interface as functional.
 * Although, its not mandatory.
 * 
 */


public class LambdaExpressions
{
	Thread t = new Thread(() ->  
	{
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(23);
		list.add(32);
		list.add(11);
		list.add(99);
		
		Collections.sort(list, (o1, o2) ->
		{
			return o1 < o2 ? -1 : o1 > o2 ? 1 : 0;
		});
		
		for(int i =0 ;i<10;i++)
		{
			System.out.println(i);
		}
	});
	
	
}

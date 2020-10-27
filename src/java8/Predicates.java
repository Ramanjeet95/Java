package java8;

import java.util.function.Predicate;

/*
 * Java has many built in functional interfaces that ship with jdk8.
 * Predicate is used for evaluating conditions.
 * It has one abstract method and many default methods like and, or, equals and negate.
 * boolean test(T t)
 * It also has one staic method not()
 * which returns boolean and takes one generic argument.
 * Predicates can be used to check any number of conditions.
 * 
 * not() method was added in java 11 it returns negate()
 * 
 * Predicate joining -
 * 
 * Predicates can be joined with other predicates for evaluating complex conditions.
 * Predicate interface has many default methods which are used to test an argument against 
 * multiple predicate conditions in various ways. This concept is called predicate joining.
 * 
 * e.g p1.and(p2).test(10);
 * 
 * 
 */
public class Predicates 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Predicate<Integer> p1 = x -> x%2==0;	//Predicate to check if no is even
		System.out.println(p1.test(12));
		
		Predicate<Integer> p2 = x -> x>10;		//Checks if no is greater than 10
		System.out.println(p2.test(12));
		
		//Predicate joining
		boolean result = p1.and(p2).test(123);	//Checks if no is even 
												//AND greater than 123
		
		result = p1.or(p2).test(123);			//Checks if no is even 
												//OR greater than 123
		result = Predicate.not(p2).test(123);	//
		System.out.println(result);
		result = p2.negate().test(123);
		System.out.println(result);
		
		
	}
	
}

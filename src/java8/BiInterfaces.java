package java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/* BiPredicate -
 * 
 * BiPredicate is almost similar to Predicate with one difference being that test method in 
 * BiPredicate takes two input arguments.Every thing else is pretty much same.
 * 
 * Boolean test(T1 t1, T2 t2);
 * 
 * BiFunction-
 * 
 * BiFunction is a built in functional interface. It is similar to Function interface.
 * Difference is BiFunction's apply method takes two arguments where as Function's apply method
 * takes one argument. 
 * 
 * default and static methods are same in both Function and BiFUnction.
 * BiFunction comes in handy when you have to take two arguments, do something with them 
 * and return an output.
 * 
 * BiFunction<Integer, String, Integer> bp = (i, s) -> r;
 * 
 * It takes three generic types, first two are types of input parameters and the 
 * third is the return type.
 * 
 * BiConsumer -
 * 
 * BiConsumer is almost similar to Consumer interface, the only difference being that 
 * Biconsumer's accept method takes two input parameters.
 * 
 * void accept(C1 c1, C2 c2)
 */

public class BiInterfaces 
{
	public static void main(String[] args) 
	{
		BiPredicate<Integer, String> bp = (a,b) -> b.length() == a;
		System.out.println(bp.test(1, "1"));
		
		BiFunction<Integer, Integer, Integer> bf = (a,b)->a+b;
		System.out.println(bf.apply(12, 11));
		
		BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1+s2);
		bc.accept("Ja", "va");
	}
}

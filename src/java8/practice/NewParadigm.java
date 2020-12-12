package java8.practice;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class NewParadigm {

	public static void main(String[] args) 
	{
		BiFunction<Integer, Integer, Integer> divide = (x, y) -> x/y;
		Function<BiFunction<Integer, Integer, Integer>, BiFunction<Integer, Integer, Integer>> 
		func = 
		(foo) ->
			(x, y)  -> 
			{
				if(y == 0)
				{
					System.out.println("Nope");
					return 0;
				}
				return foo.apply(x,y);
			};
			divide = func.apply(divide);
			System.out.println(divide.apply(1, 0));
			
			Function<Integer, Boolean> f = (x) -> x%2 ==0;
 	}
}

class Util 
{
	public static Function<Integer, Integer> createMultiplier(Integer x) {
		return n -> n * x;
	}
	
	public static BiFunction<Integer, Integer, Integer> calculator(char operator)
	{
		BiFunction<Integer, Integer, Integer> func = null;
		switch(operator)
		{
			case '+':
				func =  (x, y) -> x + y;
				break;
			case '-':
				func =  (x, y) -> x - y;
				break;
			case '*':
				func =  (x, y) -> x * y;
				break;
			case '/':
				func =  (x, y) -> x / y;
				break;
			case '%':
				func =  (x, y) -> x % y;
				break;
		}
		return func;
	}
}
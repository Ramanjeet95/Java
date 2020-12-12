package java8.practice;

import java.util.function.BiFunction;

abstract interface TriFunction<T, U, V, R>
{
	R apply(T t, U u, V v);
}

class Dummy
{
	public static double foo(int a, double s)
	{
		return a+s;
	}
}
public class Driver
{
	public static void main(String[] args) {
		BiFunction<Integer, Double, Double> foo = Dummy::foo;
		System.out.println(foo.apply(12, 2.02));
		TriFunction<Integer, Integer, Integer, Integer> prod = (a,b,c) -> a*b*c;
		System.out.println(prod.apply(1, 3, 4));
	}
}

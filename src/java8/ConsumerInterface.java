package java8;

import java.util.function.Consumer;

/*
 * Consumer interface takes one input and returns nothing. It's useful when we have 
 * to take the data and do something with it, like print it or write to a file etc.
 * It has one abstract method 
 *  void accept(T t)
 *  
 * Consumer chaining is also possible. Consumer Interface contains one default method
 * andThen() that takes another consumer. The operations are performed in sequence from first
 * to args following
 */
public class ConsumerInterface
{
public static void main(String[] args) {
	Consumer<Integer> c = r -> System.out.println(r);
	c.accept(12);
}
}

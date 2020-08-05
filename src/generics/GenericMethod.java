package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod
{
	public <T, E extends Collection<? super T>> E add(T a, E b)
	{
		b.add(a);
		return b;
	}
	
	public static void main(String[] args) 
	{
		List<Integer> list = new GenericMethod().add(1, new ArrayList<Integer>());
		list.stream().forEach(System.out::println);
	}
}

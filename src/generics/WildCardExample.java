package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class WildCardExample<T> 
{
	T t;

	public WildCardExample(T t) 
	{
		this.t = t;
	}
	
	public void doSomething(List<?> list)
	{
		//we can't add anything except null in this list here
		list.stream().forEach(System.out::println);
		List<?> list2 = new ArrayList<>();
		ArrayList<?> list3 = new ArrayList<>();
		list2 = list3;
		list2=list;
		//list3 = list;    //Won't work
	}
	
	public static void upperBound(ArrayList<? extends Collection> list)
	{
		// This method can array list of any implementation of Collection interface
	}
	
	public static void lowerBound(ArrayList<? super List> list)
	{
		ArrayList<? super List> a = new ArrayList<>();
		list.add(new LinkedList<List>());
		// This method can take array list of HashSet or any of its parent classess 
		// OR any of its ancestor interface's implementation
	}
	
	public static List lowerBound2(ArrayList<? super List> list)
	{
		ArrayList<? super List> a = new ArrayList<>();
		list.add(new LinkedList<List>());
		// This method can take array list of HashSet or any of its parent classess 
		// OR any of its ancestor interface's implementation
		return a;
	}
	
	public static void main(String[] args) 
	{
		ArrayList<List> al = new ArrayList<>();
		al.add(new ArrayList());
		lowerBound(new ArrayList<Collection>());
		upperBound(new ArrayList<ArrayList>());
		ArrayList<?> ll = new ArrayList<>();
		ArrayList lll = new ArrayList<>();
		List<?> ss = new ArrayList<>();
		List<String> list = new ArrayList<>();
		//list = ss; 		//does not work
		ll = lll;
	}
}

package generics;

import java.util.HashMap;
import java.util.Map;

public class CustomMap<T , E extends CharSequence> 
{
	private Map<T, E> map = new HashMap<T, E>();
	
	public CustomMap() 
	{	}
	
	public CustomMap(T t, E e)
	{
		put(t, e);
	}
	
	public void put(T key, E value)
	{
		map.put(key, value);
	}
	
	public E get(T key)
	{
		return map.get(key);
	}
	
	public static void main(String[] args)
	{
		CustomMap<Integer, String> map  = new CustomMap<>(1, "Raman");
		System.out.println(map.get(1));
	}
}

package collections;

import java.util.HashMap;
import java.util.Map;

public class Maps 
{
	public static void main(String[] args) 
	{
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.putIfAbsent("1", "2");	//only puts if key not present
		map.forEach((k,v) -> System.out.println(k+v));			//BiConsumer
		map.entrySet().forEach(c -> System.out.println(c.getKey()+c.getValue())); //Consumer
		System.out.println(map);
	}
}

package generics;

import java.util.ArrayList;
import java.util.List;

public class Temp
{
	public static void m1(List<?> l)
	{
		//l.add("Raman");
		//l.add(1);
		System.out.println(l);
	}
	
	public static ArrayList m2()
	{
		return new ArrayList();
	}
	
	public static <T extends String>void mindFuck(ArrayList<? extends Cat> a, T aa)
	{
		System.out.println("is it done?");
	}
	
	public static void main(String[] args)
	{
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("a");
//		list.add("a");
//		list.add("b");
//		System.out.println(list);
//		list.remove("a");
//		System.out.println(list);
		
		int i = 0, sum = 0;
		sum = ++i + i++ + i++ + ++i;
				
		System.out.println(sum);
		
		for(i = 0; i<10; ++i)
			System.out.println("Raman" + i);
	}
	
}


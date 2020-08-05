package generics;

public class BoundedClass<T extends Animal & Shiny> 
{
	public BoundedClass(T t) 
	{
		System.out.println(t.getClass().getName());
	}
	//You can't use T defined with the class to declare args in a static method 
	//because Parameter Type is instance level and static methods are class level
//	public static int show(T arg1, T arg2) 
//	{
//		return 0;
//		
//	}
	
	
	public static void main(String[] args) 
	{
		new BoundedClass<BlackCat>(new BlackCat());
	}
	
}

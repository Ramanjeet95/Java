package generics;

public class FirstGenericClass<T> 
{
	private T a;

	public FirstGenericClass(T a) 
	{
		this.a = a;
	}
	
	public void show()
	{
		System.out.println(a.getClass().getName() + " " + a);
	}
	public static void main(String[] args) 
	{
		new FirstGenericClass<String>("Raman").show();
		new FirstGenericClass<Student>(new Student(1, "Raman")).show();
	}
}

class Student
{
	private int id;
	private String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
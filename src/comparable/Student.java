package comparable;

import java.util.TreeSet;

public class Student implements Comparable<Student>
{
	private int id;
	private String name;
	
	Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Student o) 
	{
		return id < o.id ? -1 : id == o.id ? 0 : 1;
	}
	
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args)
	{
		TreeSet<Student> set = new TreeSet<Student>();
		set.add(new Student(1,"Raman"));
		set.add(new Student(2, "Maran"));
		set.add(new Student(3, "Raman"));
		set.add(new Student(4, "Champ"));
		System.out.println(set);
	}
}

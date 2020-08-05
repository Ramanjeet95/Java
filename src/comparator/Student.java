package comparator;

import java.util.Comparator;
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

	class ComparatorImpl implements Comparator<Student>
	{

		@Override
		public int compare(Student o1, Student o2) 
		{
			return 0;
		}
		
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

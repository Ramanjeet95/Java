package java8;

/*
 * Function<T, R> is a built in functional interface. It has one method apply().
 * e.g 		R apply(T t)
 * 
 * Function is useful in situations where we need to take an input, process it 
 * and then return a value.
 * 
 * Function chaining is also possible given that the input and output types match. Function has two default methods andThen(), compose()
 * and one static identity()
 * 
 * andThen() first applies the first Function and then applies the argument function.
 * compose() first applies the argument function and then applies the first function.
 * 
 * e.g 
 * 
 * f1.andThen(f2).apply(10);  //first f1's apply will be called then result will be processed by f2's apply
 * f1.compose(f2).apply(10);  //first f2's apply will be called then result will be processed by f1's apply
 * 
 *  
 */

import java.util.function.Consumer;
import java.util.function.Function;

class Student
{
	private String name;
	private int marks;
	
	Student(int marks, String name)
	{
		this.marks = marks;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getMarks() 
	{
		return marks;
	}

	public void setMarks(int marks)
	{
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "name=" + name + ", marks=" + marks;
	}

}

public class FunctionInterface
{
	public static void main(String[] args) 
	{
		Function<Student, String> func = s ->
		{
			int marks = s.getMarks();
			return marks > 80 ? "A" : marks > 60 ? "B" : marks > 40 ? "C" : marks > 35 ? "D" : "E";
		};
		
		Student[]sArray = {
						   new Student(40, "Rashid"), 
						   new Student(50, "Deepak"), 
						   new Student(60, "Sahul"),
						   new Student(80, "Rahul")
						   };
		//Consumer<Student[]> consumer = s -> Stream.of(s).forEach(System.out::println); 
		Consumer<Student> consumer = s -> System.out.println("name : " + s.getName() + ", grade : " + func.apply(s)); 
		for(Student s : sArray)
			consumer.accept(s);
		
		
		Function<String, Integer> f1 = s -> s.length();
		Function<Integer, Boolean> f2 = i -> i>2;
		System.out.println(f1.andThen(f2).apply("asda"));	//Chaining
		System.out.println(f2.compose(f1).apply("asda"));	//Chaining
	}
}

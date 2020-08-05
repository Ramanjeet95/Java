package cloning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/* Cloning : Creating a copy of an object is called cloning. There are two types of cloning
 * 1.) Shallow Cloning
 * 2.) Deep Cloning
 * 
 * 1.) Shallow Cloning : If object to be cloned has references to other objects, in shallow cloning, copy of only the base object is created and references of the contained objects are copied to the new base object copy.
 * 						 Which means new objects are not created for references contained within the base object. Here, base object is the object on which we called clone() method. Original object and cloned object both point to
 * 						 the same contained objects, if contained objects are modified in either, change will reflect in the other as well.
 * 
 * 		e.g consider this 2 dimensional array    
 * 			int[][] arr = {{1,2,3}, {4,5,6}};
 * 		    int[][] arrCopy = arr.clone();
 * 			
 * 			By default array cloning is shallow cloning. Here a new object is created for the base array and the reference of the contained arrays are copied to the new base array object.
 * 			
 * 			arr[0][0] = 12;
 * 			this will reflect in both the original object and the copy because new objects were not created for nested arrays.
 * 				
 * 
 * 2.) Deep Cloning : Deep cloning is full cloning that is cloning at all the levels. In this copy object is created for base object as well as for every reference object contained within it. It is a more complete form of cloning.
 * 					  In case of deep cloning, if contained objects are modified in main object, the changes will not reflect in the copy object and vice versa, because they are different objects.
 * 
 * 	IMPORTANT : 
 * 	
 *  1.) clone() method is defined in Object class. By default its implemented for shallow cloning. In order to make an object eligible for deep cloning, clone() method needs to be overridden in the particular class and class needs to implement Cloneable interface. 
 * 	2.)	It is not possible to override clone() for predefined class and therefore we can not do deep cloning for pre existing classes and arrays because they use clone() method from Object class which is for shallow cloning.
 *  3.) Constructor is not called while cloning. 
 * 
 */
public class Cloning
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		//We'll take the example of 2 dimensional array
		int[][] arr = {{1,2,3}, {4,5,6,}};
		int[][] arrClone = arr.clone();					//Shallow Cloning
		
		arrClone[0][2] = 66;
		//Stream.of(arrClone[0]).forEach(System.out::println);
		Arrays.stream(arr).flatMap(x -> Stream.of(Arrays.stream(x))).forEach(s -> s.forEach(System.out::println));
		//We changes in arrClone but change gets reflected in arr as well because we performed shallow cloning
		Student ss = new Cloning().new Student(1, "Raman");
		Student ss2 = ss.clone();
		System.out.println(ss2);
	}
	class Student implements Cloneable
	{
		int id;
		String name;
		List<String> list = new ArrayList<>() {{
			add("SST");
			add("Science");
		}};
		public Student(int id, String name)
		{
			this.id = id;
			this.name = name;
		}
		//Deep Cloning
		@Override
		protected Student clone() throws CloneNotSupportedException
		{
			Student copyS =  (Student)super.clone();
			copyS.list = new ArrayList<>(list);
			return copyS;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}
		
	}
}

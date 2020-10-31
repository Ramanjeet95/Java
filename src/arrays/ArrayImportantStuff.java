package arrays;

import generics.Temp;

/*
 * One line Array Initialisation -
 * 
 * Its possible to declare, create and initialise arrays in a single line.
 * 		int a[][] = {{1,2,4},{5,6,7,8}};
 * 
 * Important : Array can only be initialised this way if everything is done in one line, we can not split this statement into two lines. For example following is invalid initialization.
 * 			   int[] a;
 * 			   a = {1, 2, 3}; --- invalid
 * 			   Arrays can also be declared in the following way.
 * 			   int[] a = new int[]{34, 45, 56};
 * 			   This is called as anonymous array. We can't specify size while initializing anonymous array. Anonymous arrays are used when we need to use the array instantly.
 * 			   int a[] = {};  		//valid, creates array of 0 size
 * 
 * Array Casting -
 * 
 * It is very important to remember that we can implicitly cast compatible types for e.g. short to int, int to long etc.
 * 			short s = 2;
 * 			int i = s  //Valid 
 * 
 * But in case of primitive arrays we can not cast one array to another even if they are of compatible types. 
 * For e.g. 
 *  		int[] intArray = new int[12];
 *  		long[] longArray = new long[13];
 *     		longArray = intArray;     				//Invalid
 *     		longArray = (long[])intArray;            //Explicit cast also invalid       
 *    
 *    This is invalid and we will get a compile time error because int array class type is [I and long array type is [L, these classes don't have
 *    a parent child relationship therefore arrays of these types can't be implicitly casted to the other.
 * 		
 *    However, There are different rules for arrays of object type. An object type array can be assigned to an array of its parent type without having to explicitly cast it to the parent type given that they are of the same dimensions.
 *    for e.g. 
 *    		Object[] objArray = new Object[10];
 *    		String[] stringArray = new String[12];
 *    		objArray = stringArray; 				// Valid as String is a subtype of Object
 *    
 *    Important : If you try to assign a child to the array, which is different from the actual type of array, there will be no compile time exception but at runtime there will be ArrayStoreException. 
 *    			  This happens because at compile time only reference type is checked but at runtime the actual type of the array is checked by JVM.
 *    
 *    for e.g. 
 *    		Object[] objArray = new String[10];
 * 			objArray = new Integer(3);  				//Valid but there will be exception at runtime
 * 			objArray = new StringBufffer("Hello");		//Valid but there will be exception at runtime
 * 			
 */
public class ArrayImportantStuff
{
	interface Temp
	{
		
	}
	public static void main(String[] args) 
	{
		int a[][] = new int[2][2];
		int[] smallArray = {12,14,11};
		smallArray = new int[] {1,2,3,4};
		
		double[][] doubleArray = new double[3][2];
		//doubleArray = (double[][])a;						//Invalid
		
		int[] arr  = new int[23];
		//long[] arrl = arr; 									//Invalid 
		
		var aee = 3;
		class Student implements Temp
		{
			private String name;
			private int id;
			
			public Student(String name, int id) 
			{
				super();
				this.name = name;
				this.id = id;
			}
		}
		
		class Employee extends Student implements Temp
		{
			private int salary;
			
			public Employee(String name, int id, int salary) 
			{
				super(name, id);
				this.salary = salary;
			}
		}
		
		Employee[] empArray = new Employee[12];
		Student[] stuArray = new Student[43];	
		stuArray = empArray;						//We can directly cast child type array to parent type, this is not possible for primitive types
		empArray = (Employee[])stuArray;
		Temp[] tempArr = new Temp[12];
		tempArr = empArray = (Employee[])tempArr;   //Valid
	}
}

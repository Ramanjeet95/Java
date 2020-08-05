package variables;

import java.util.ArrayList;
import java.util.List;

/*
 * LVTI : Local variable type inference was introduced in java 10. From java 10, local variables can be declared and initialized using var keyword. 
 * 		  It can be used to declare primitive variables, arrays and objects. When we declare a local variable using var keyword the type is inferred from the right side 
 * 		  of the assignment. In order for the compiler to infer the type it is necessary to declare and initialize in the same line otherwise there will be compile time error.
 * 		  Which means var can not be used for uninitialized variables and null initializations. 
 * 		  e.g   		var a;				//invalid, compiler can not infer type
 * 						var obj = null;		//invalid, this is initialized but type can not be inferred
 * 		  In java we can not use keywords as identifiers, but we can use var as an identifier because it is required only at compile time, at compile time var is replaced by the type of the value assigned and it does not exist at runtime. 
 * 		  e.g 			var var = 12;		//valid
 * 		  Also, var can not be used to declare method parameters, method return type, instance variables and static variables. It can be used to only declare local variables in constructors, statement block or static blocks.
 * 		  It can also be used as index variables in for loops.
 * 		  In case of arrays, square brackets [] are not required to declare arrays. There will be a compile time error if we try to use square brackets [] while declaring array with var. 
 * 		 
 * 		  var[] arr = new int[10];				// invalid to use [] with var
 * 		  var arr[] = new int[10];				// also invalid
 * 		  
 * 		  Also, arrays can not be assigned to var by the initializer i.e {}, we have to use anonymous array syntax to initialize arrays using var keyword.
 * 	
 * 		  var arr = {1, 2, 3};			//Invalid because type can not be inferred
 * 		  var arr = new int[]{1, 2, 3};  //Valid because type can be inferred   
 * 
 * 		  IMPORTANT: Even after the introduction of var, java is still strictly typed or strongly typed language. Once a value is assigned to a variable 
 * 					 declared with var, its type is decided and it can only interact with that type after that i.e its type can not be changed after its assigned. 
 * 					 If we try to assign some other type value, there will be compile time error.
 * 			
 * 					 for e.g.	
 * 								var a = 67;
 * 								a = "Hello";					//Invalid because type of a is already decided which is int
 * 
 * 
 */
public class LocalVariableTypeInference
{
	public static void main(String[] args) 
	{
		var arr = new int[1];
		var list = new ArrayList<>();
		//arr = ""; 					//Invalid
		var obj = new ArrayList<String>();
		obj.add("Raman");
		obj.add("Sachin");
		obj.add("Tarun");
		genericMethod(obj);
		obj.add("Ankush");
		for(var a:obj)									//We will get class cast exception here as well
		{
			System.out.println(a.getClass().getName());
			System.out.println(a);
		}
	}
	
	public static void genericMethod(List list)
	{
		list.add(12);
	}
}

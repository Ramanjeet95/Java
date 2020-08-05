package variables;

/* Identifiers : Before we talk about variables, first we have to talk about identifiers. An Identifier is a name which is used to identify something 
 * 				 for e.g. class, method or a variable etc. In java an identifier can be a combination of 0-9, a-z, A-Z, _, $. That being said it can not start with a digit
 * 				 and any reserved keyword can not be used as an identifier.
 * 				 e.g. _num, $5, a1 etc
 * 
 * 				 IMPORTANT: In java 9 _ is also a reserved keyword therefore, only _ can not be used as an identifier after java 9. It can still be used with a combination of other allowed symbols. 
 * 
 * Variables   : A Java variable is a piece of memory that can contain a data value. A variable thus has a data type. Variable is sort of like a container of a particular data type that can hold data.
 *  		     A variable has a particular name, which is an identifier according to java conventions and a data type which identifies the type of data variable can hold. In java there are two classifications 
 *  			 of variables :
 *   
 * 1. Based on Data Stored : Based on the type of value that a variable can hold it can be one of the following.
 * 							 
 * 		a) Primitive Variables : These variables store primitive data like integers, float etc.
 * 		b) Reference Variables : These are used for storing reference to an object. e.g. String or any user defined type
 * 
 * 2. Based on Scope : Based on scope there are three types of variables in java, which are as follows.
 * 
 * 		a) Instance Variables
 * 		b) Class Variables
 * 		c) Local Variables
 * 		
 * 		a) Instance Variables : Important points about instance variables are as follows
 * 			i.   Instance variables are unique to each object. 
 * 			ii.  They are created when the object is created and are destroyed when the object is destroyed by garbage collector.
 * 			iii. Instance variables are stored in the heap memory because they are part of the object.
 * 			iv.  They are initialized with default values if not explicitly initialized.
 * 			v.   They can not be accessed without an object i.e an object must exist for instance variables to be accessed because they can not exist independently.
 * 			vi.  Instance variables are declared in the class outside any method or other blocks.
 * 			vii. If we try to access instance variable directly from static method without creating an object, there will be an compilation exception "Non Static variable can not be accessed from a static context".
 * 
 * 		b) Class Variables : Class variables are used when something common, among all the objects of a class, needs to be represented. 
 * 							 For e.g. If there is a Student class representing students of a college, college name will be common for all the students.
 * 		    
 *           Important points about instance variables are as follows 	
 *           i.   Class variables are declared with static keyword. They are also called static variables.
 *           ii.  Class variables are also initialized with default values by jvm if they are not explicitly initialized.   
 * 			 iii. Class variables are stored in method area.
 * 			 iv.  They are created when the class is first loaded by the class loader and they exist untill the class exists in class loader's memory.
 * 	 		 v.   Class variables can be accessed by class name or by object. It is recommended to access class variables using class name.
 * 			 vi.  An object is not required to access class variables as they belong to the class. Only one copy exists for every object. Every object shares the same copy.
 * 			 vii. Class variables are also declared inside class outside of any method or other block.
 * 			 viii.Class variable can be access with a reference that has null, there is no runtime exception because object is not required to access class variables.
 * 						for e.g.   
 * 							class Temp{
 * 							 	static int a;
 * 								public static void main(String[] args){
 * 									Temp t = null;
 * 									System.out.println(t.a);					//This will not throw runtime exception 
 * 								}
 * 							}
 * 
 * 		c) Local Variables : Important points about local variables are as follows 
 * 		     i.   Local variables are temporary variables. Local variables are declared inside methods or a particular block e.g. for loop etc. 
 * 			 ii.  Local variable have the same scope as the encompassing block. They exist only in that block.
 * 			 iii. Local variables are stored in stack memory.
 * 			 iv.  They are not initialized by the jvm if left uninitialized. A compile time time error is thrown if local variables are not initialized.
 * 			 v.   Any type of modifiers except final are not allowed with local variables. 
 * 			 vi.  Local variables can have the same name as a instance variable or a class variable but its not recommended because they hide the instance/class variable in its scope.
 *  		 vii. Java 10 introduced a new keyword var which can be used to declare local variables.
 *  		 viii.There will be no initialization error for local variable if it is not used anywhere.
 */
public class Variables 
{
	int a;					//instance variable
	String name;			//instance variable
	static int num;			//class variable
	
	public static void main(String[] args)
	{
		int i;							//local variable
		final int x = 12;				//local constant
		//This is an interesting scenario where if final local variable is taken in if condition and only one block initializes the local variable, even then no compile time error.
		//if final is removed there will be compiltaion error 
		if(x > 10)
		{
			i = x;
			//x = x++;
		}
		else
		{
			System.out.println(x);
		}
		System.out.println(i + " "+ x);
	}
}

package dataTypesAndLiterals;

import java.util.concurrent.Callable;

/* Operators can seem to be simple but there are some interesting concepts related to operators. Operators perform a specific operation on one or more operands and produce a result.
 * In java there are three types of operators. 
 * 			1. Unary  
 * 			2. Binary
 * 			3. Conditional
 * 
 * Unary : These require only one operand, e.g. increment, decrement, which further have two types pre and post.
 * 			
 * Increment Operator: - Increment operator increases the value of operand by 1. It is only applicable for numeric operands. 
 * Decrement Operator: - Decrement operator decreases the value of operand by 1. It is also applicable for numeric types.		  
 *  			e.g  ++x	==>   x = x+1;		   
 * 		  			 x = ++y;			//pre increment, y is incremented first and then assigned to x
 * 		   			 x = y++;			//post increment, first y is assigned to x, and then it is incremented.
 * 					 x = --y;			//pre decrement, y is decremented first and then assigned to x
 * 					 x = y--;			//post decrement, first y is assigned to x, and then it is decremented.
 * One important point to remember about increment and decrement operators is that implicit casting is performed. Also, they are not applicable on constants. They can not be nested.
 * e.g. 
 * 					byte x = 127;
 * 					++x;			
 * In above code there will be no compilation error because casting is performed implicitly before assignment. Same type of casting is also performed for compound operators e.g +=, -= etc.
 * 				i.e        ++x; 	==>      x = (byte)(x+1);
 * 
 * VERY IMPORTANT : In case of post increment/decrement following sequence of steps happen 
 * 					1.) Consider the value for assignment or use, i.e  the current value.
 * 					2.) Increment the value by 1
 * 					3.) Use the original value for assignment.
 * 
 * e.g				int x = 10;
 * 						x = x++;
 * 						x = x++;
 * 						x = x++;
 * 					in the above code, value of x will be 10 at the end. This is because the value that is to be assigned is considered at the beginning and since we are assigning to the same 
 * 					variable incremented value is lost and 10 is assigned. In case of pre increment the result will be as expected.	
 * 
 * Binary : These require two operands, e.g arithmetic operators, logical operators, bitwise operators and comparison operators. e.g +=, 
 * 		
 * Bitwise Operators : These are binary operators as well, they are used to manipulate bits. and(&), or(|), xor(^), complement(~), left shift(<<), right shift(>>), unsigned right shift(>>>) are the bitwise operators
 * 					   in java. We can use them in compound form by combining them with assignment operator e.g &=, |= etc. &, |, ^ are applicable for both boolean and integer types, but the remaining ~, >>, <<, >>> are 
 * 					   applicable only for integer types. Bitwise operators can not be applied to floating point numbers.
 * 
 * 
 * Conditional Operator : ?: is called conditional operator. e.g a>b? true:false; It is the only ternary operator in java.
 * 
 * instanceof Operator : This operator is used for checking if an object is of a particular type. Result is either true or false. In order to apply instanceof operator there must be a relationship between the
 * 						 type of object that is being checked and the type against which it is being checked for. 
 * 						 e.g t instanceof Thread.
 * 						 in the above example type of t must have a parent child relationship with Thread, otherwise compilation will fail.
 * 						 There is a small relaxation for interfaces, that is if we are checking against an interface, the object's type does not need to implement the interface to compare it with that interface, there
 * 						 will be no compilation error in case of unrelated interface. 	
 * IMPORTANT: 
 * 1.) In case of arithmetic operators if the type of operands is not same then type of result is determined as max(int, type of a, type of b). Basically what it means is that smaller operand 
 * 			  is type cast to bigger operand. If both operands are smaller than int, both are type cast to int before operation is performed. Resulting type of arithmetic operations is at least int.
 * 			  byte a = 5;
 * 			  byte b = 44;
 * 			  byte c = a + b;			//Compilation error, int can not be cast to byte 
 * 
 * 2.) '+' operator is used for both arithmetic addition and String concatenation in java. If at least one operand is of type String, + is considered as string concatenation operator. 
 *     e.g   "a"+2+2 => result will be "a22", this expression is evaluated from left to right. 
 *     		 12+14+"aaa"+2+4  => result will be "26aaa24". Basically, after a string is encountered the operation becomes string concatenation.
 *     
 * 3.) If we try to divide an integer by 0, we will get ArithmeticException at runtime. But, if we try to divide a floating point value by 0 or an integer by 0.0, 
 *     there will be no exception and result is Infinity and if we try to divide negative float with 0, result will be -Infinity. If we try to divide 0 by 0, we get ArithmeticException because its considered as integer division.
 *     If we divide 0.0 by 0, we get Nan as output, which is a special constant which represents not a number or undefined.Rule of type promotion is applicable for division as well. 
 * 
 * 5.) If we try to compare a number with NaN including NaN, result is always false.
 * 	   e.g Nan == NaN, 10>NaN, 123<NaN 				//all returns false
 * 
 * 4.) Type promotion is also performed while using relational operators between different type of operands. Chaining of relational operators is not allowed
 * 	   e.g  12>34>35>90			//invalid	
 * 
 * 5.) Except for == and != all the other relational operators are applicable for all primitive types except boolean and can not be used with object references except wrapper classes. ==, != are applicable for all types including boolean 
 * 	   and also for objects as well. For == comparison operands must either be of the same type or there must be a parent child or ancestor child relationship between them, otherwise compilation error will occur. == compares the object references and not the value.
 * 
 * 6.) Difference between == and equals() method is that equals() method compares the content of the objects while == operator compares the references as in if both references point to the same object then it will return true else false. By default, equals() method is present
 * 	   in Object class and compares references we have to override it in child class to compare values. If different type object is passed to equals() method it returns false.
 * 
 * 7.) && and || are called short circuit operators, differences between && and &, | and || are as follows
 * 		i.)   & and | are applicable for both integer and boolean types, however && and || are only applicable for boolean types.
 * 		ii.)  In case of &&, if the first condition is false, the subsequent conditions are not evaluated but in case of & the subsequent conditions are also evaluated
 * 		iii.) In case of ||, if the first condition is true, the subsequent conditions are not evaluated but in case of | the subsequent conditions are also evaluated.
 * 
 * 8.) Important thing to remember about bitwise complement(~) is that its result depends on size of the variable as well. e.g if we are finding complement of int a = 4; complement will be computed for all the 32 bits, since size of integer is 32 bit in java. 
 * 
 * 9.) Positive numbers are stored in memory as there binary representation and negative numbers are stored in 2's complement form. 2's complement is computed by first finding 1's complement and add 1 to it. Most significant bit is used to represent the sign of the number.
 *  
 * 10.) null instanceof <AnyType> is always false. and null instanceof null is invalid. Also, every child type object is automatically of its parent type as well. 
 * 
 * 11.) int a = b = c = 10; is invalid because we did not declare b,c.
 */
public class Operators 
{
	public static void main(String[] args) 
	{
		byte x = 127;
		//x = x + 1;			//Compilation error
		x++;					//post-increment, here no error because it casts the result to byte, result will be -128 
		
		Byte b1 = 2;
		b1++;					//auto unboxing
		
		Byte b2 = 3;
		//Byte b3 = b1+b2;		//compilation error, same rules apply for wrapper classes as well
		
		final byte s1 = 3;
		final byte s2 = 3;
		byte s3 = s1+s2;		//if operands are final no compilation error
		
		byte a = 3;
		int c = 34;
		int product = a*c;		//a is cast to int
		
		int a1 = 2147483647;
		int a2 = 2147483647;
		var a3 = a1 + a2;			//this does not cause problem
		System.out.println(a3);
		
		var sss = ++a+ a++;			//8, a = 5
		System.out.println(sss+" "+a);
		sss = ++a + ++a + a++ + a++ + a;			//6+7+7+8+9
		System.out.println(sss);		//37
		
		char cha = 'a';
		System.out.println(++cha);			// cha = (char)(cha+1);
		
		final char c1 = 'a';
		final char c2 = 'b';
		char c3 = c1 + c2;					//compilation error if c1 , c2 not final
		System.out.println(c3);
		
		System.out.println('a'+'b');		//result will be integer 195 because default is int and here no casting is performed
		
		int z1 = 3, z2 = 12, z3 = 122;
		System.out.println(z1+z2+"Raman"+z1+z2);			//result is "15Raman312"
		System.out.println(z1+z2+"Raman"+(z1+z2));			//result is "15Raman15", if we specify parenthesis first it is evaluated
		System.out.println("Hello"+z1+z2+z3);				//result is "Hello312122"
		
		//int div = z1/0;									//ArithmeticException at runtime, can't divide by 0
		double divD = -z2/0.0;								//no exception, result is -Infinity
		System.out.println(divD);
		
		divD = z2/0.0;
		System.out.println(divD);							//no exception, result is Infinity
		
		//int div = 0/0;									    //Exception occurs
		divD = 0/0.0;										
		System.out.println(divD);							//no exception, NaN
		
		String ss1 = "Raman";
		String ss2 = "Raman";
		System.out.println(ss1 == ss2);						//true, because java uses string pool, if string literal is used java checks in the string pool, if it finds the same literal it returns the same else it creates			
	
		String ss3 = new String("Raman");
		System.out.println(ss1 == ss3);						//false, every time new object is created in the heap if we use new keyword even if it exists in string pool
		System.out.println(ss1.equals(ss3));				//String equals compares contents hence true
		
		StringBuilder ssb1 = new StringBuilder("Raman");
		StringBuilder ssb2 = new StringBuilder("Raman");	
		System.out.println(ssb1 == ssb2); 					//false, both are separate objects, == compares references
		System.out.println(ssb1.equals(ssb2));				//false, StringBuilder does not override equals()
		
		System.out.println(ss3.equals(ssb1));				//false, type of objects being compared must be same otherwise equals() returns false
		
		//System.out.println(ssb1 == ss1);					//CE because String and StringBuilder don't have parent child relationship
		//bitwiseOperators();
		//assignmentAndinsatanceof();
		specialCase();
		//conditionalOperator();
	}
	
	//%|^~>>><<>>
	public static void bitwiseOperators()
	{
		int a = 5, b = 6;
		System.out.println(a&b);		// 5 = 101 and 6 = 110,  5&6 = 100 = 4
		
		a = 12;
		b = 18;
		System.out.println(a|b); 		//12 = 1100 and 18 = 10010,  12|18 = 11110 = 30
		
		a = 365;
		b = 489;
		System.out.println(a^b);		//365 = 101101101 and 489 = 111101001, 365^489 = 132
		
		a = 5678;
		System.out.println(~b);			//5678 = 1011000101110 and ~5678 = -490
		
	}	
	
	public static void assignmentAndinsatanceof()
	{
		Object o = new Object();
		String s = "Raman";
		StringBuilder sb = new StringBuilder("haha");
		//System.out.println(s instanceof StringBuilder);			//compilation error, String and StringBuilder don't share parent child relationship
		System.out.println(s instanceof Object);					//true, because all child types are automatically of the parent type as well
		System.out.println(o instanceof String);					//false, because o is an instance of Object class not String
		o = new Thread();
		System.out.println(o instanceof Object);					//true, o is an instance of Thread and Object because Object is parent of Thread
		System.out.println(o instanceof Thread);					//true
		System.out.println(o instanceof Runnable); 					//true, Thread implements Runnable
		class A{}
		A a = new A();
		System.out.println(a instanceof Runnable);					//false, no compilation error because in case of interfaces we can compare unrelated types
		//System.out.println(s instanceof Runnable);				//Compilation error, String is a final class, so it can not have any subclass that implements Runnable
	
		//int x=b=c=12;												//invalid
		int x,b,c;
		x=b=c=12;													//valid
		c &= 69;
		System.out.println(c);
		b /= c;
		System.out.println(b);
		x+=b;
		System.out.println(x);
		
		x = b = c = 12;
		x += b /= c &= 70; 											//valid, we can chain multiple assignment and compound operators
		System.out.println(x + ", " + b + ", " + c);
	}
	
	public static void specialCase()
	{
		int x = 10, y = 10;
		
		x = x++;							//valueToBeAssigned = 10  
											//x = x + 1
											//x = valueToBeAssigned
		x = x++;
		x = x++;
		System.out.println(x);				//10
		
		y = x++;							//y = 10, x = 11 
		y = x++;							//y = 11, x = 12
		y = x++;							//y = 12, x = 13
		System.out.println(x + ", " + y);	//x = 13 , y = 	12
		
		x = ++x;							//x = 14
		x = ++x;							//x = 15
		x = ++x;							//x = 16
		x = ++x;							//x = 17
		System.out.println(x);
		x += x++ + ++x + x++ + ++x;		
		//This will be evaluated as follows
		//x = x + (x++ + ++x + x++ + ++x);					//x = 17
		//x = 17 + (17 + ++x + 18 + ++x);					//x = 19
		//x = 17 + (17 + 20 + 18 + 21);						//x = 21
		//x = 17 + 76;
		//x = 93;
		System.out.println(x);								//x = 93
	}
	
	public static void conditionalOperator()
	{
		int x = 10, y = 12;
		System.out.println(x>y?x:y>x?y+x:x);
	}
	
}

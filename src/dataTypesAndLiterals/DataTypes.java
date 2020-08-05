package dataTypesAndLiterals;


/*			DATA TYPES, LITERALS ANS TYPE CASTING
 * 
 * There are two types of data types in Java
 * 	1. Primitive Types 
 * 	2. Reference Types(User defined types)
 *  
 *  Primitive Types :- These are default data types that come in-built in java. 
 *  There are 8 basic primitive types in Java. Primitive types can be further divided into two categories.
 *  a) Numeric Types
 *  b) Non Numeric types
 *  
 *  	a) Numeric Types - These are used to represent numbers of different types. Like, int, float etc. There are seven Numeric types in Java.
 *  		1) byte  - 	Byte represents the 1 byte integer. Its size is 1 byte and Range is from -128 to 127. Its default value is 0. Corresponding wrapper class is Byte.
 *  		2) short - 	Bigger than byte. Its size is 2 bytes and range is -32768 to 32767. Default value is 0. Corresponding wrapper class is Short.
 *  		3) int   -  Bigger than short. Its size is 4 byte and range is -2147483648 to 2147483647. Default value is 0. By default every integer is of type int. Corresponding wrapper class is Integer.
 *  		4) long  -  It is used for big integer values. Its bigger than int. Its size is 8 bytes and range is -2^63 to 2^63-1. Default value is 0. Corresponding wrapper class is Long.
 *  					Since every integer by default is of type int, we need to append l or L at the end of integer to represent it as long.
 *  		5) float -  Float represents single precision floating point numbers. Its size is 4 bytes and range is -3.4e38 to 3.4e38. Default value is 0.0. Corresponding wrapper class is Float.
 *  					Integers and floating point numbers are represented differently in memory, because of which 8 byte long can be implicitly cast to float.
 * 						By default all floating point numbers are of double type. Therefore to identify a floating point number as float we need to append f or F at the end.
 * 			6) double-  Double represents a double precision floating point number. Its size is 8 bytes and range is -1.7e308 to 1.7e308. Default value is 0.0. Corresponding wrapper class is Double.
 * 						Its bigger than float. We can append d or D at the end but its not required as by default are floating point numbers are of type double.  
 * 			7) char  -  char represent a single unicode character.It represents unsigned values. Its size is 2 bytes and range is 0 to 65535. Default value is 0(Space character). Corresponding wrapper class is Character.
 * 						Its considered to be an integer type because internally character's unicode integer value is stored.
 * 		
 * 		b) Non-Numeric Types - There is only one non numeric primitive type.
 * 			1) boolean - This is used to represent simple logical true or false. Its size depends on jvm. Default value is false. Corresponding wrapper class is Boolean.
 * 
 * 		IMPORTANT! : There are four ways to initialize integer type using literals. You can assign Decimal, Octal, HexaDecimal and Binary literals(jdk 1.7 onwards) to Integer data types but JVM can only print in decimal form. We can NOT assign Octal, Hexadecimal and binary Floating point literals to Floating type data types.
 * 					 If we append 0 in front of floating point literal, there is no compile time error but its not considered as Octal. However, we can assign Decimal, Hexadecimal, Octal and Binary INTEGER literals to floating point data types. 
 * 
 * 		Type casting : When we assign value of one data type to another, if the types are compatible then java automatically converts it to target type this is called implicit casting or widening or up casting and if types are not compatible than there is a compile time error. In case of incompatible types we have to perform explicit casting which is also called Narrowing or down casting.
 * 					   
 * 					   byte -> short -> int -> long -> float -> double
 * 							   char ->  int -> long -> float -> double  
 * 
 * 					   Casting from left to right is implicit and right to left is explicit
 */
public class DataTypes
{
	public static void main(String[] args) 
	{
		//Decimal values and assignment
		byte by = 11;
		short sh = 1;
		char ch = 97;
		ch = 'A';
		int in = 1;
		in = 'b'; // valid because internally unicode value is stored which is int
		long lo = 2147483648l;
		float fl = 0.02f;
		double dou = 0.00002;
		
		//Octal values and assignment
		byte byt = 0177;
		System.out.println(byt);
		short sht = 077777;
		System.out.println(sht);
		char cht = 0177777;
		System.out.println(cht);
		int intr = 017777777777;
		System.out.println(intr);
		long lon = 0177777777777777l;
		System.out.println(lon);
		float flt = 0230.02f;
		System.out.println(flt);
		double doul = 0320.00002;
		System.out.println(doul);
		
		flt = 0776;
		doul = 022221; // possible
		
		//Hexadecimal values and assignment
		byte byh = 0x7f;
		System.out.println(byh);
		short shh = 0xc8d;
		System.out.println(shh);
		char chh = 0x598;
		System.out.println(chh);
		int inth = 0x786;
		System.out.println(inth);
		long lonh = 0x9add;
		System.out.println(lonh);
		float flth = 0230.02f;
		System.out.println(flth);
		double doulh = 0320.00002;
		System.out.println(doulh);
		
		flth = 0x781;
		doulh = 0x812a; //possible
		
		//Binary values and assignment
		byte byb = 0b1001;
		System.out.println(byh);
		short shb = 0b00010;
		System.out.println(shh);
		char chb = 0b1110;
		System.out.println(chh);
		int intb = 0b10101;
		System.out.println(inth);
		long lonb = 0b11101;
		System.out.println(lonh);
		float fltb = 230.02f;
		System.out.println(flth);
		double doulb = 320.00002;
		System.out.println(doulh);
		
		fltb = 0B10101;
		doulb = 0B10101; // possible
		
		dou = fl = lo = in  = sh = by;// upcasting or widening 
		
		dou = fl = lo = in  = ch;
		
		fl = lo; // valid despite long being bigger 8 bytes and float being 4 bytes
		lo = (long)fl;// explicit cast required here
		
		by = (byte)sh;
		sh = (short)in;
		in = (int)lo;
		lo = (long)fl;
		
		
		
		System.out.println(ch);
	}
}

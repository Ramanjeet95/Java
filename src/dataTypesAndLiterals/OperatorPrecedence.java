package dataTypesAndLiterals;

/*
 * Precedence : If there are multiple operators in an expression, order of execution of the operators is defined by Operators Precedence.
 * 				Precedence for Unary operators is highest followed by binary operators and finally the ternary operator has the least precedence. 
 * 				If there are multiple operators in an expression with same precedence, they are evaluated from left to right. Operands are always 
 * 				evaluated from left to right regardless of operators. Parenthesis are evaluated first. Assignment operator has the least precedence.
 * 				Only assignment is evaluated from right to left, other operators are evaluated from left to right.
 * 
 * Precedence Tree is as follows, precedence decreases from top to bottom
 * 
 * 					
 * Parenthesis -				()
 * 	
 * Unary -					    x++,x--
 * 								++x, --x, ~, !
 * 								new, cast operator
 * 
 * Binary-						*,/,%
 * 								+,-
 * 								>>,<<,>>>
 *                              <,<=,>,>=, instanceof
 *                              ==, !=
 * 
 * Bitwise						&
 *                              ^
 *                              |
 *                              
 * Shortcut                     &&
 *                              ||
 *                              
 * Ternary                      ?:
 * 
 * Assignment                   =,+=,*=, &= etc
 *                              
 * IMPORTANT : If the position of MSB's of two numbers is not same, the result of bitwise & operator will be 0. 						
 */
public class OperatorPrecedence 
{
	public static void main(String[] args) 
	{
		int i = 120;
		i -= --i + i++ - ++i + i++;
		//120 - (119 + 119 -121 + 121);		 
		System.out.println(i); 				//-118
		
		int a = 2, b= 34, c = 4;
		
		int d = a+b/c%a + ++c*1/12%2;
			  //2+34/4%2 + 5*1/12%2	
			  //2+8%2 + 5*1/12%2
			  //2 + 0 + 5/12%2
			  //2 + 0 + 0%2
			  //2 + 0 + 0
		System.out.println(""+a+b+d);				//2
		
		int z = a&=b * 2/d/2;
		//z = a = a&b*2/d/2;
		//z = a = 2&34*2/2/2;
		//z = a = 2&68/2/2;
		//z = a = 2&34/2;
		//z = a = 2&17;					10 & 10001  = 19
		//z = a = 19
		System.out.println(z);			//0
		
	}
}

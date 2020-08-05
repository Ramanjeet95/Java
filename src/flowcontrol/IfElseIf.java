package flowcontrol;

/*
 * These statement are used to control the flow of execution of the program. There are three types of flow control statements.
 * 1.) Branching Statements(if, if else, if elseif, switch)
 * 2.) Looping Statements(for, while, do-while, for-each)
 * 3.) Jumping Statements(continue, break, return, try-catch-finally)
 * 
 * IMPORTANT : If statements executes a statement or block of statements based on a boolean condition. Curly braces are optional in case of if, if-else, else-if, if there is only one statement.
 * 			   ; if considered an empty statement. Important thing is if only supports boolean as argument unlike switch. If there are only one or two options than its better to use if or if else instead of switch.
 * 				But if there are a lot of options then its better to use switch statement. We can also use conditional operator instead of if-else if number of options are small. Performance of both switch and if-else is same.
 * 				But switch improves code readability. Parenthesis are optional with if, however without parenthesis only one statement is allowed and it can't be declarative statement.    
 * 
 * 				if(true)
 * 					int x = 10;		//invalid
 * 				
 * 				There is no dead code compilation error if we use false in if
 * 				e.g. if(false)
 * 					 { 
 * 						syso();
 * 					 }
 * 					 syso();				//No compilation error
 * 				
 */
public class IfElseIf
{
	public static void main(String[] args) 
	{
		if(10>3)
		{
			System.out.println("Hello");
		}
		boolean b;
		if(b = true)
			System.out.println("done");		//{} are optional here
		
		if(10>2);				//valid because ; is considered an empty statement
		
		if(true);			//valid
		else
			System.out.println("");
		
		//if(true)
			//int x = 3;			//invalid
		
		if(false)
		{
			System.out.println();
		}
		System.out.println();
	}
}

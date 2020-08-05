package flowcontrol;

/*
 * Switch statement is another decision making statement. It is recommended to use switch when there are a lot of options.
 * Switch statement has cases which pertains to different options that we are comparing. It can also have a default case. If no
 * case is matched  the default case is executed. Basic structure of switch statement is as follows 
 * 
 * 			switch(x)
 * 			{
 * 				case 1:
 * 				break;
 * 	            case 2:
 * 				break;
 *              . 
 *              .
 *              .
 *              default:
 *              break;
 * 			}
 * 
 * IMPORTANT:  
 * 
 * 1.) Parenthesis are mandatory with switch statement and an empty switch is perfectly valid syntax. 
 * 2.) default case does not have to be the last case in switch, it can be placed at any position.
 * 3.) Both case and default statements are optional. 
 * 4.) In switch statement there is a concept called fall through. Fall through means that if a case matches the input, the execution will continue
 *     until either a break is encountered or the end of switch block is reached. Basically, if there is no break in a case, all the remaining cases will 
 *     execute unless there is a break.
 * 5.) Input types supported by switch case are byte, short, char and int. These are the only primitive types supported by switch case and there wrapper classes are also supported.
 * 	   boolean, long, float, double are not supported. Since Java 1.5 Enum type is also supported and since java 1.7 String can also be used with switch statements.
 * 6.) In case of String equals method is used to determine the match.
 * 7.) We can also use labelled blocks in case statements 
 * 8.) Type of case constants to be matched against the provide value is determined by the type of argument passed to switch case. for example If byte type arg is passed to switch we can not use
 * 	   int values as case constants.
 * 9.) Duplicate values are not permitted in case and only comparable values are permitted in cases. Also, case expression must be a constant.
 * 10.) Case label must always be a constant expression.
 * 11.) Chars are evaluated at compile time, so when using char as case label for integer switch arg, the value can not be same as another int case.   
 */
public class Switch
{
	public static void main(String[] args) 
	{
		final byte x = -12;
		switch(x)
		{
			default:
				System.out.println("default");
				break;
			case 127:
				System.out.println("127");
			case 11:
				System.out.println("11");
				break;
			case x:
				System.out.println("-12");
				break;
			case -1:
				System.out.println("default");
		}
		
		switch(124)
		{
			case 2|23:
			{
				
			}
			
			case 97:
			{
				
			}
			
			//case 'a':			//invalid
			//{
				
		//	}
			default:
			{
				
			}
		}
	}
}

//import java.util.Scanner;
//
//public class temp 
//{
//public static void main(String[] args) 
//{
//        Scanner sc = new Scanner(System.in);
//        int t=sc.nextInt();
//
//        for(int i=0;i<t;i++)
//        {
//            try
//            {
//                long x = sc.nextLong();
//                if(x < -Math.pow(2, 64) && x > Math.pow(2, 64) - 1) 
//                {
//                    System.out.println(x + "can't be fitted anywhere.");
//                }
//                else
//                {
//                    System.out.println(x+" can be fitted in:");
//                    if(x>=-128 && x<=127)System.out.println("* byte");
//                    if(x>=-32768 && x<= 32767)System.out.println("* short");
//                    if(x>=-Math.pow(2, 32) && x<= Math.pow(2, 32)-1)System.out.println("* int");
//                    if(x>=-Math.pow(2, 64) && x<= Math.pow(2, 64)-1)System.out.println("* long");
//            }
//            }
//            catch(Exception e)
//            {
//                System.out.println(sc.next()+" can't be fitted anywhere.");
//            }
//
//        }
//    }
//}

interface A
{
	void m1();
}

public class temp 
{
	public static int m2()
	{
		System.out.println("a");
		return 21;
	}
	public static void main(String[] args) {
		A a = temp::m2;
		a.m1();
	}
	
}
package flowcontrol;

public class ForLoop
{
	public static void main(String[] args)
	{
		int i = 2;
		for(System.out.println("First");i != 0;System.out.println("Third"))
		{
			System.out.println("Second");
			i--;
		}
	}
}

package oops.overriding;
/*
 * Private methods can not be overridden because private members are not inherited.
 * However, inner classes can access the private members of its outer class.
 * Private methods are bonded at compile time i.e its the type of the reference that
 * determines what method to call instead of actual object;
 */

class OverridingPrivateMethods
{
	private void hello()
	{
		System.out.println("Hello Parent");
	}
	
	private double check(double a, String b)
	{
		return a;
	}
	
	private double check(String b, double a)
	{
		return a;
	}
	
	class Inner extends OverridingPrivateMethods
	{
		private void hello()
		{
			System.out.println("Hello from inside");
		}
	}
	
	public static void main(String[] args) 
	{
		OverridingPrivateMethods p = new Child();
		p.hello();						
		
		Inner i  = p.new Inner();
		i.hello();
		p = i;
		p.hello();				//not overridden
	}
	
}

class Child extends OverridingPrivateMethods
{
	//@Override
	private void hello()					//not an overridden method
	{
		System.out.println("Hello Child");
	}
	
}


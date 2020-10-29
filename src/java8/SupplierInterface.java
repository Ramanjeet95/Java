package java8;

import java.util.function.Supplier;

/*
 * Supplier interface is one of the many default functional interfaces added in java8
 * This interface is useful for "supplying" things. It can be used when there is a need for
 * generating something. Example can include a DB connection or any object.
 * It has one abstract method get() which does not take any input.
 * 
 * R get();
 */
public class SupplierInterface
{
	public static void main(String[] args) {
		Supplier<String> supplier = () -> 
		{
			String num = "";
			for(int i = 0 ; i < 6; i++)
				num = num + (int)(Math.random()*10);
			return num;
		};
		
		System.out.println(supplier.get());
	}
}

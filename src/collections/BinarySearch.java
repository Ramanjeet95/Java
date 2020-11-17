package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * There are two ways to perform binary search in java, 
 * 
 * Arrays.binarySearch(array, key);
 * Collections.binarySearch(List, key);
 */
public class BinarySearch 
{
	public static void main(String[] args)
	{
		int[] a = {1,9,2,3,44,5,6,71};
		
		System.out.println(Arrays.binarySearch(a, 6));
		List<String> list = new ArrayList<>();
		System.out.println(Collections.binarySearch(list, "one"));
	}
}

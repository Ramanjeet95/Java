package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Why does Java's Arrays.sort method use two different sorting algorithms for different types?
 * 
 * 1. According to Java 7 API docs cited in this answer, Arrays#Sort() for object arrays now uses TimSort,
 * which is a hybrid of MergeSort and InsertionSort. On the other hand, Arrays#sort() for primitive arrays
 * now uses Dual-Pivot QuickSort. These changes were implemented starting in Java SE 7.
 * 
 * The most likely reason: quicksort is not stable, i.e. equal entries can change their relative position 
 * during the sort; among other things, this means that if you sort an already sorted array, it may not stay unchanged.
 *
 * Since primitive types have no identity (there is no way to distinguish two ints with the same value), this does
 * not matter for them. But for reference types, it could cause problems for some applications. Therefore, a stable
 * merge sort is used for those.
 *
 * OTOH, a reason not to use the (guaranteed n*log(n)) stable merge sort for primitive types might be that it requires
 * making a clone of the array. For reference types, where the referred objects usually take up far more memory than the
 * array of references, this generally does not matter. But for primitive types, cloning the array outright doubles the memory
 * usage.
 * 
 * Arrays.sort() and Collections.sort() used to use quick sort for primitives and merge sort for object types. Since java 7
 * they both use Timsort.
 */
public class Sorting 
{
	public static void main(String[] args)
	{
		List<String>list = new ArrayList<>();
		String[] array = new String[10];
		Collections.sort(list, Collections.reverseOrder());
		Arrays.sort(array, Collections.reverseOrder());
		// Sort subarray from index 1 to 4, i.e., 
        // only sort subarray {7, 6, 45, 21} and 
        // keep other elements as it is. 
        Arrays.sort(array, 1, 5); 
	}
}

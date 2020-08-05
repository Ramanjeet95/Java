package arrays;

/*
 * Array is a collection of homogeneous data elements that are stored in contiguous memory locations. Arrays are of fixed size.
 * Every thing in java is an object including Arrays. Every type of array also has corresponding classes, these classes exist in java language instead of java library, therefore we can not access them.
 * Following are class name for different types of arrays - 
 * 			int[]       -  [I
 * 			int[][]     -  [[I
 * 			byte[]      -  [B
 * 			boolean[][] -  [[Z
 * 			String[]    -  [Ljava.lang.String
 * 			Object[]    -  [Ljava.lang.Object
 */

public class ArraysIntro
{
	public static void main(String[] args)
	{
		//Declaration
		//One dimensional array
		int[] a;
		a = new int[0];// valid creates an array of 0 size, can be used as args when no command line arg is passed
		int  []b;
		b = new int[-12];//Also valid because index must be an int. It compiles fine but at runtime we get NegativeArraySizeException
		int c[];
		c = new int['a'];
		int d [];//Valid as space is discarded by the compiler
		d = new int[2147483647];//Max size allowed for array in java(Max value of int)
								//Also it will probably give out of memory error at runtime because it needs 2147483647 x 4 bytes of memory
		//Two dimensional array
		int[][] e;
		int[] []f;
		int [][]g;
		int []h[];
		int i[][];
		int[] j[];
		
		//Three dimensional array
		int[][][] k;
		int[][] []l;
		int[][] m[];
		int[] []n[];
		int[] o[][];
		int []p[][];
		int q[][][];
		int [][][]r;
		int[] [][] s;
		int [][]t[]; 
		
		//Multiple array declaration
		
		int[] ss, sp;			//ss - 1d, sp - 1d
		int[] []sd, sf;			//sd - 2d, sf - 2d space is ignored by compiler and its treated as int[][] so both will have that applied
		int[] sa[], az[];       //sa - 2d, az - 2d
		//int[] []da, []xa;		//Invalid, can only specify brackets in the front for first variable
		int[] []gf, gj[];
		
		sf = new int[12][12];
		gj = new int[10][10][10];
	}
}

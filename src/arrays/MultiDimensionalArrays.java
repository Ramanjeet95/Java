package arrays;

public class MultiDimensionalArrays 
{
	/*
	 * In java multi dimensional arrays are implemented with array of arrays concept. In multidimensional arrays you can specify base size and leave the rest empty, and you can initialise internal arrays manually.
	 *  e.g. int a[][] = new int[2][];
	 *  	 a[0][0] = new int[3];
	 *  	 a[0][1] = new int[5];
	 *  
	 *  this approach is useful if the child arrays are of different size, if the size is same for internals arrays then it's better to specify size in the array creation.
	 */
	public static void main(String[] args) 
	{
		String[][][] a = new String[2][][];
		a[0] = new String[2][];
		a[1] = new String[3][];
		
		a[0][0] = new String[3];
		a[0][1] = new String[3];
		
		a[1][0] = new String[2];
		a[1][1] = new String[3];
		a[1][2] = new String[1]; 
		
		a[0][0][0] = "000";
		a[0][0][1] = "001";
		a[0][0][2] = "002";
		
		a[0][1][0] = "010";
		a[0][1][1] = "011";
		a[0][1][2] = "012";
		
		a[1][0][0] = "100";
		a[1][0][1] = "101";
		
		a[1][1][0] = "110";
		a[1][1][1] = "111";
		a[1][1][2] = "112";
		
		a[1][2][0] = "120";
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				for(int k = 0; k < a[i][j].length ; k++)
				{
					System.out.println(a[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
}

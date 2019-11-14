import java.io.*;
import java.util.*;

class LargestSubarrayLengthK{

	public static void main(String[] args) throws IOException {
		int[] A = {1,4,3,2,5};
		int k = 4;
		int index = largestSubarray(A,k);
		int[] ans = new int[k];
		int ansIndex = 0;
		for(int i = index;i<index+k;i++)
			ans[ansIndex++] = A[i];

		//Printing the result array
		for(int i = 0;i<ans.length;i++)
			System.out.print(ans[i] + "\t");
	}

	public static int largestSubarray(int[] arr, int k)
	{
		//the length of the contiguous subarry must be equal to k
		//loop through the array to get the starting points of all possible subarrays
		int maxValueIndex = 0;
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0;i<= arr.length - k; i++)
		{
			if(arr[i]>maxValue)
			{
				maxValue = arr[i];
				maxValueIndex = i;
			}
		}
		return maxValueIndex;
	}

}
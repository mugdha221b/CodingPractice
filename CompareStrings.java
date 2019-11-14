import java.io.*;
import java.util.*;

class CompareStrings{
	static String[] arr1;
	static String[] arr2;
	static int[] finalAnswers;


	public static void main(String[] args) throws IOException{
		String A = new String("abcd aabc bd");
		String B = new String("aaa aa");
		compareFunction(A,B);
		//printing the final result
		for(int i =0 ;i<finalAnswers.length;i++)
		{
			System.out.print(finalAnswers[i] + "\t");
		}
	}//end of main function

	public static void compareFunction(String A, String B)
	{
		arr1 = A.trim().split(" ");
		arr2 = B.trim().split(" ");
		//We now have the words from string A in arr1
		//The words from string B are in arr2

		//declare two arrays for the count of smallest characters
		//for words from A and for words from B
		int[] countA = new int[arr1.length];
		int[] countB = new int[arr2.length];

		//for each word in arr1, we need the frequency of 
		//the smallest character
		//call the function for each word
		for(int i = 0;i<arr1.length;i++)
		{
			String str = arr1[i];
			int c = count(str);
			countA[i] = c;
		}

		for(int i = 0;i<arr2.length;i++)
		{
			String str = arr2[i];
			int c = count(str);
			countB[i] = c;
		}

		finalAnswers = new int[arr2.length];
		//now check how many of the values from countA are less for each value from countB

		for(int i = 0;i<countB.length;i++)
		{
			int c = 0;
			for(int j = 0;j<countA.length;j++)
			{
				if(countA[j]<countB[i])
					c++;
			}
			finalAnswers[i] = c;

		}


	} //End of function compareFunction()

	public static int count(String str)
	{
		int[] alphabetCount = new int[27];
		Arrays.fill(alphabetCount,0);

		int ans = 0;

		for(int i = 0;i<str.length();i++)
		{
			alphabetCount[str.charAt(i) - 'a']++;
		}

		for(int i = 0;i<alphabetCount.length;i++)
		{
			if(alphabetCount[i]!=0)
			{
				ans = alphabetCount[i];
				break;
			}
		}
		return ans;




	}//End of function count

}
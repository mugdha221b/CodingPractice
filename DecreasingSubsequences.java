import java.io.*;
import java.util.*;


class DecreasingSubsequences{
	public static void main(String[] args) throws IOException{

			int[] arr = {5,2,4,3,1,6};

			int answer = minNumberOfDecreasingSubsequences(arr);
			System.out.println(answer);

	}

	public static int minNumberOfDecreasingSubsequences(int[] arr)
	{
		//Use an arraylist to store the last element of each subsequence
		//If the current Number is bigger than any element in the arraylist then add that number to the end of the list
		//Else get the first element bigger than the current number
		//and replace it with currentNumber

		ArrayList<Integer> tails = new ArrayList<Integer>();
		for(int i = 0 ;i<arr.length;i++)
		{
			if(tails.size()==0)
				tails.add(arr[i]);
			else
			{
				int val = arr[i];
				

				//get the first element greater than the current number which is val
				int flag = 0;
				int index = -1;
				for(int j = 0;j<tails.size();j++)
				{
					int tail = tails.get(j);
					if(tail>val)
					{
						flag = 1;
						index = j;
						break;
					}
				}


				//If you find no element greater than val then add val to tails arrayList
				if(flag == 0)
					tails.add(val);
				else
				{
					//replace the first number in arrayList that is greater than val with val
					tails.set(index, val);
				}

			}

		}
		return tails.size();
	}
}

import java.io.*;
import java.util.*;

class NumberOfRefills{
	public static void main(String args[]) throws IOException
	{
		int[] plants = {2,4,5,1,2};
		int capacity1 = 5;
		int capacity2 = 7;

		int answer = numberOfRefills(plants, capacity1,capacity2);
		System.out.println("The number of refills required is " + answer);
	}

	public static int numberOfRefills(int[] plants, int capacity1,int capacity2)
	{

		
		if(plants == null || plants.length==0)
			return 0;
		if(plants.length == 1)
		{
			if(plants[0]<=capacity1 || plants[0]<=capacity2)
				return 1;
			if(plants[0]<=(capacity1 + capacity2))
				return 2;
		}
		int count = 2;

		int start1;
		int end1;
		int start2;
		int end2;
		int mid = plants.length/2;
		if(plants.length%2 == 0)
		{
			// left to right should go from 0 to mid-1
			// right to left should go from plants.length-1 to mid
			start1 = 0;
			end1 = mid-1;
			start2 = plants.length-1;
			end2 = mid;
		}
		else
		{
			// left to right should go from 0 to mid-1
			// right to left should go from plants.length-1 to mid+1
			start1 = 0;
			end1 = mid-1;
			start2 = plants.length-1;
			end2 = mid+1;
		}

		
		
		int bucketValue1 = capacity1;
		for(int i = start1;i<=end1;i++)
		{
			if(plants[i]<=bucketValue1)
				bucketValue1-=plants[i];
			else
			{
				count++;
				bucketValue1 = capacity1;
				bucketValue1-=plants[i];
			}
			// System.out.println("After watering plant " + plants[i] + ", the bucket capacity is " + bucketValue1);
		}

		int bucketValue2 = capacity2;
		for(int i = start2;i>=end2;i--)
		{
			if(plants[i]<=bucketValue2)
				bucketValue2-=plants[i];
			else
			{
				count++;
				bucketValue2 = capacity2;
				bucketValue2-=plants[i];
			}
			// System.out.println("After watering plant " + plants[i] + ", the bucket capacity is " + bucketValue2);
		}
		if(plants.length%2 == 0)
		{
			return count;
		}
		if(plants[mid]<= (bucketValue1 + bucketValue2))
			return count;
		if(plants[mid]<= (capacity1+bucketValue2) || plants[mid]<=bucketValue1 + capacity2)
			return(count+1);
		return(count+2);



	}
}
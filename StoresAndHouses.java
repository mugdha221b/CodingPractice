import java.util.*;
import java.io.*;


class StoresAndHouses{
	public static void main(String[] args)throws IOException{
		int[] houses = {5,10,17};
		int[] stores = {1,5,20,11,16};
		
		int[] nearestStores = new int[houses.length];

		getNearestStores(houses,stores,nearestStores);

		//printing the result
		for(int i =0 ;i<nearestStores.length;i++)
			System.out.print(nearestStores[i] + "\t");

	}

	public static void getNearestStores(int[] houses, int[] stores, int[] nearestStores)
	{
			TreeSet<Integer> treeSet = new TreeSet<Integer>();
			//Add all the stores in the treeset 
			//adding them in a treeset keeps them in a sorted order
			for(int store : stores)
				treeSet.add(store);

			//For each house, get the smallest value greater than  or equal to the house by treeSet.ceiling(val)
			//Get the biggest value smaller than or equal to the house by treeSet.floor(val);
			for(int i = 0;i<houses.length;i++)
			{
				int houseVal = houses[i];
				Integer left = treeSet.floor(houseVal);
				Integer right = treeSet.ceiling(houseVal);

				if(left == null || right == null)
				{
					//i.e if there is no such element greater than or equal to OR there is no such element less than or equal to houseVal
					nearestStores[i] = (left == null)?right:left;

				}
				else
				{
					//Both not null
					nearestStores[i] = (houseVal - left)<(right - houseVal) ? left : right;

				}
			}

	}
}
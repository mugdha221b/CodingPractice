import java.io.*;
import java.util.*;

class FillMatrix{
	public static void main(String[] args)
	{
		int n = 3;
		int[][] magicSquare = new int[n][n];
		buildMagicSquare(n,magicSquare);

		//printing the magic square

		for(int i =0 ;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				System.out.print(magicSquare[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void buildMagicSquare(int n,int[][] magicSquare)
	{
		//initially fill the magic square with values -1
		//-1 will denote that a cell in that square is empty
		for(int i = 0;i<n;i++)
			Arrays.fill(magicSquare[i],-1);

		//The numbers we will be adding will be from 1 to n*n
		int number = 1;
		//For the startPoint, x,y will be n/2 and n-1
		int x = n/2;
		int y = n-1;
		while(number<=n*n)
		{
			//The positions for the current number will be denoted by x,y
			magicSquare[x][y] = number;


			//Set the positions for the next number
			//the next positions for the current x,y are given as x-1 and y+1
			x = x-1;
			y = y+1;
			
			//check if that position is occupied already
			if(x<n && x>=0 && y<n && y>=0 && magicSquare[x][y]!=-1)
				{
					x = x+1;
					y = y-2;
				}

			//check for the validity of the new positions

			if( (x == -1) && (y == n))
			{
				x = 0;
				y = n-2;
			}
			else if( x == -1)
			{
				x = n-1;
			}
			else if(y == n)
			{
				y = 0;
			}






			number++;
		}
	}
}
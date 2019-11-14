import java.util.*;
import java.io.*;


class MaximumTime{
	public static void main(String[] args) throws IOException{

		// String time = new String("?4:5?");
		// String time = new String("23:5?");
		// String time = new String("2?:22");
		// String time = new String("0?:??");
		String time = new String("??:??");
		String bestTime = resolveTime(time);
		System.out.println("Best time for " + time + " is : " + bestTime);
	}

	public static String resolveTime(String time)
	{
		String[] arr =  time.trim().split(":");
		String p1 = String.valueOf(arr[0].charAt(0));
		String p2 = String.valueOf(arr[0].charAt(1));
		String p3 = String.valueOf(arr[1].charAt(0));
		String p4 = String.valueOf(arr[1].charAt(1));

		//check for missing times from values from left to right

		//getting the value of the first blank
		if(p1.equals("?"))
		{
			//The value of p1 is to be determined
			//there are two cases to be considered

			
			if(p2.equals("?"))
			{
				//case 1
				//where p2 is blank
				p1 = "2";
			}
			else
			{
				//else
				//the value of p2 is known

				int num2 = Integer.valueOf(p2);
				if(num2>3)
					p1 = "1";
				else
					p1 = "2";

			}

		}

		//getting the value of the second blank
		if(p2.equals("?"))
		{
			if(p1.equals("0") || p1.equals("1"))
				p2 = "9";
			else if(p1.equals("2"))
				p2 = "3";
		}

		//the best value for the third blank will always be 5
		if(p3.equals("?"))
		{
			p3 = "5";
		}

		//the best value for the fourth blank will always be 9
		if(p4.equals("?"))
		{
			p4 = "9";
		}

		String bestTime = p1+p2+":"+p3+p4;
		return bestTime;
	}
}
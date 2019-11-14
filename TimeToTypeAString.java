import java.io.*;
import java.util.*;

class TimeToTypeAString{
	public static void main(String args[]) throws IOException{

		String keyboard = new String("abcdefghijklmnopqrstuvwxy");
		String text = new String("cba");
		int answer = totalTime(keyboard,text);
		System.out.println("Total Time taken = " + answer);


	}
	public static int totalTime(String keyboard,String text)
	{
		if(keyboard == null || text == null || keyboard.length() == 0 || text.length() == 0)
			return 0;
		HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();
		for(int i = 0;i<keyboard.length();i++)
		{
			hashmap.put(keyboard.charAt(i),i);
		}
		int ans = Math.abs(hashmap.get(text.charAt(0)) - 0);
		for(int i = 1;i<text.length();i++)
		{
			int index1 = hashmap.get(text.charAt(i-1));
			int index2 = hashmap.get(text.charAt(i));
			ans+=Math.abs(index2 - index1);
		}
		return ans;

	}
}
package CodeLibrary;
/**
 * @author Divyanshu Gandhi
 * @description Program for creating a letter frequency table and also prints a histogram with
 * asterisks. Letter frequency meaning an array to represent number of times a letter shows up.
 * eg, index of 'A' in the array will be 0 and it will hold the number of times 'A' shows up in
 * the string.
 * Codewars 2015
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterFrequencyHist {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("y2012p08.txt"));
		int[] letters = new int[26];
		String line="";
		while((line = f.readLine())!=null && !(line.equals("###")))
		{
			line = replaceAllNonAlphanumericCharacters(line);
			line = line.toUpperCase();
			for(int i=0;i<line.length();i++)
			{
				letters[findAlphaNumber(line.charAt(i))]++;
			}
		}
		displayHistogram(letters);
		System.exit(0);
		f.close();
	}

	public static String replaceAllNonAlphanumericCharacters(String str)
	{
		return str.replaceAll("[^a-zA-Z]", "");
	}
	public static int findAlphaNumber(char s)
	{
		int val;
		val = ((int)s-(int)'A');
		return val;
	}
	public static void displayHistogram(int[] freqs)
	{
		int max;
		int maxIndex=-1;
		for(int i =0;i<freqs.length;i++)
		{
			max = Integer.MIN_VALUE;
			for(int j=0;j<freqs.length;j++)
			{
				if(freqs[j]>max)
				{
					max = freqs[j];
					maxIndex=j;
				}
			}
			freqs[maxIndex]=-1;
			System.out.print((char)(maxIndex+(int)'A')+" ");
			for(int k=0;k<max;k++)
			{
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}

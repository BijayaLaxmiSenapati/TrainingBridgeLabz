/**
 * purpose:search a word from a comma separated file.
 * @author:Bijaya Laxmi Senapati
 * @since:22/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;
import java.io.IOException;
import java.util.Arrays;

import com.bridgelabz.utility.Utility;

public class BinarySearchFromFile
{

	
	public static void main(String[] args) throws IOException
	{
		Utility utility=new Utility();
		String fileName="/home/adminstrato/BijayaWorkSpace/readfile";
		String readedFile=utility.readAllFromFile(fileName);
		String[] wordArray=readedFile.split(",");
		Arrays.sort(wordArray);
		for(int i=0;i<wordArray.length;i++)
		{
			System.out.println(wordArray[i]);
		}
		System.out.println("enter the searching element");
		String search=Utility.retNextLine();
		int index=Utility.stringBinarySearch(wordArray,search);
		System.out.println("the word is present at "+index+" index");
	}

}

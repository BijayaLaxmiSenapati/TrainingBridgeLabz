package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.datastructureprograms.MyDeque;
import com.bridgelabz.datastructureprograms.MyLinkedList;
import com.bridgelabz.datastructureprograms.MyQueue;
import com.bridgelabz.datastructureprograms.MyStack;
import com.bridgelabz.objectorientedprograms.Person;

public class Utility {

	static Scanner scr = new Scanner(System.in);

	
	
	/**
	 * @return number a user given number
	 */
	//function to return a Integer value which is given by user.
	public static int retInt() {         
		return scr.nextInt();
	}

	
	/**
	 * @return String a user given word
	 */
	 //function to return a word of String value which is given by user.
	public static String retNext() {      
		return scr.next();
	}

	
	/**
	 * @return String a user given sentence/multiple words
	 */
	 //function to return a String line which is given by user.
	public static String retNextLine() {      
		return scr.nextLine();
	}



	/**
	 * @return boolean a user given boolen value
	 */
	public static boolean retBoolean() {
		return scr.nextBoolean();
	}


	/**
	 * @return number a number which is of double type and is given by the user
	 */
	public static double retDouble() {
		return scr.nextDouble();
	}
	
	
	
	

	public static long retLong() {
		
		return scr.nextLong();
	}
	
	

	/**
	 * Function to create the array of user's choice
	 * 
	 * @param noOfElements to store the array length to be created
	 * @param array to store the elements in the array
	 * @return the integer array created
	 */
	public static int[] createIntegerArray() {
		System.out.println("Enter the number of elements you want to store:-");
		int noOfElements = Utility.retInt();
		System.out.println("Enter the elements to be stored:-");
		int[] array = new int[noOfElements];
		for(int i=0; i<noOfElements; i++) {
			array[i] = Utility.retInt();
		}
		return array;
	}



	/**
	 * function to replace a proper username given by user with <<UserName>> from
	 * the template String
	 * @param String template from which <<User Name>> should be replaced with actual/proper username
	 * @return String uname which is a proper name, given by the user
	 */

	public static String replaceUsrName(String template,String uname) {
		
		String t = "";
		if (uname.length() < 3) {
			System.out.println("enter a proper name. The username should have atleast 3 charecters");
			return null;
		} else {
			String[] templarr = template.split(" ");
			for (int i = 0; i < templarr.length; i++) {
				if (templarr[i].equals("<<UserName>>,")) {
					templarr[i] = uname + ",";
				}
			}
			for (int i = 0; i < templarr.length; i++) {
				t = t + templarr[i] + " ";
			}

		}
		return t;

	}

	

	/**
	 * @param n number to print all the power value of 2 upto 'n'th power of 2
	 */
	public static void printPowOf2(int n) {         //function to print the power of 2 upto the given range of power
		if (n >= 0 && n < 31) {
			for (int i = 0; i <= n; i++) {
				System.out.println("2^" + i + "=" + (int) Math.pow(2, i));
			}
		} else {
			System.out.println("You have entered a number which is out of the range");
		}
	}
	
	/**
	 * @param year year to check for leap year
	 * @return String message for Leap year or not
	 */
	public static String checkLeapYear(int year) {        //function to check a year is leap year or not
		if (year >= 1000 && year <= 9999) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {

				return "Leap Year";
			} else {

				return "not a Leap Year";
			}
		} else {
			return "You have entered a wrong year";
		}
	}

	
	/**
	 * @param n number upto which harmonic number should be calculated
	 * @return double which is the n'th harmonic number
	 */
	public static double printNthHarmonic(int n) {         //function to print Nth harmonic number, i.e 1/1 + 1/2 + .... + 1/N
		
		double nthHarmonicNumber = 0;
		if (n < 0) {
			System.out.println("invalid number");

		} else {
			for (double i = 1; i <= n; i++)// for floating point operations atleast one operand should be double or
				// float
			{
				// System.out.println(1/i);
				nthHarmonicNumber += 1 / i;
			}
			
		}
		return nthHarmonicNumber;

	}

	

	/**
	 * @param numberOfTimes a number upto which a coin should be flipped
	 */
	public static void percentOfHeadTail(int numberOfTimes) {         //function to calculate percentage of head and tail after flipping a coin
		
		double tail = 0;
		double head = 0;/*
		 * if you will declare tail and head as integer then there will be a problem in
		 * the calculation i.e "(5/10)*100=0" and this problem can be solved by
		 * (5*100)/10=50
		 */
		double percentHead;
		double percentTail;
		for (int i = 0; i < numberOfTimes; i++) {
			if (Math.random() < 0.5) {
				tail++;
			} else {
				head++;
			}
		}

		percentHead = (head / numberOfTimes) * 100;
		percentTail = (tail / numberOfTimes) * 100;

		System.out.println("percentage of head is " + percentHead);
		System.out.println("percentage of tail is " + percentTail);
	}

	
	/**
	 * @param n a number of which all the prime factors is printed
	 * @return set the distict list of integers/prime factors
	 */
	 //function to return all prime factors of a given number
	public static Set<Integer> printPrimeFactors(int n) {         //function to return all prime factors of a given number
		int m=n;
		Set<Integer> s = new HashSet<Integer>();
		while (m % 2 == 0) 
		{
			s.add(2);
			m = m / 2;
		}
		for (int i = 3; i <= Math.sqrt(m); i = i + 2) {
			if (m % i == 0) 
			{
				s.add(i);
				m = m / i;
			}
		}
		if (m > 2) {
			s.add(m);
		}
		return s;
	}

	
	/**
	 * @param stake number that a player have
	 * @param goal number, the player have to make to win
	 * @param chance number of times the player is allowed to play
	 */
	//function to calculate the number of times a player wins and looses in gambling
	public static void calWinLossInGambling(int stake, int goal, int chance) {       
		int win = 0;
		int loss = 0;

		for (int i = 0; i < chance; i++) {
			while (stake < goal && stake > 0 && chance > 0) {
				if (Math.random() >= 0.5)
				{
					stake++;
					win++;
					chance--;
				} 
				else 
				{
					stake--;
					loss++;
					chance--;
				}
			}
		}
		double percentWin = (win * 100) / (win + loss);
		double percentLoss = (loss * 100) / (win + loss);
		System.out.println("the player won " + win + " times.");
		System.out.println("the player lost " + loss + " times.");
		System.out.println("percentage of win is " + percentWin + "%");
		System.out.println("percentage of loss is " + percentLoss + "%");
	}

	/**
	 * @param number the number of distinct coupon number required
	 * @return number the number of random elements created to get the required coupon numbers
	 */
	public static int generateCouponNum(int number) 
	{
		
		Random rand = new Random();
		List<Integer> arr = new ArrayList<>(number);
		arr.add(rand.nextInt(number));
		System.out.println(arr.get(0));
		int count = 1; //number of times random number generated
		int j = 1;  //number of times distinct number generated 
		while (j < number) {
			int r = rand.nextInt(number);
			//System.out.println(r);
			//System.out.println(arr.contains(r));
			if (arr.contains(r)) {
				count++;
				//System.out.println(count);
				continue;
			} else {
				count++;
				//System.out.println(count);
				arr.add(r);
				/*for(int i=0;i<arr.size();i++)
				{
					System.out.println(arr.get(i));
				}*/
				j++;
				System.out.println("the value of j "+j);
			}
		}
		System.out.println("count="+count);
		return count;
	}



	/**
	 * @param option a number which is given as option to create an array
	 */
	public static void print2DArray(int option)
	{
		System.out.println("enter number of rows of the 2D array");
		int row=Utility.retInt();
		System.out.println("enter number of columns of the 2D array");
		int col=Utility.retInt();
		System.out.println("enter elements of the 2D array row wise");
		Integer[][] intArray;
		Double[][] doubleArray;
		Boolean[][] boolArray;
		switch(option)
		{
		case 1:
			intArray=new Integer[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					intArray[i][j]=Utility.retInt();
				}
			}
			print2DArrayElement(intArray);
			/*for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(intArray[i][j]+" ");
				}
				System.out.println();
			}*/
			break;
		case 2:
			doubleArray=new Double[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					doubleArray[i][j]=Utility.retDouble();
				}
			}
			print2DArrayElement(doubleArray);
			/*for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(doubleArray[i][j]+" ");
				}
				System.out.println();
			}*/
			break;
		case 3:
			boolArray=new Boolean[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					boolArray[i][j]=Utility.retBoolean();
				}
			}
			print2DArrayElement(boolArray);
			/*for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(boolArray[i][j]+" ");
				}
				System.out.println();
			}*/
			break;
		default:
			System.out.println("you have given one invalid input");
		}

	}
	
	
	/**
	 * @param inputArray the array element to be sorted.
	 */
	//function to print elements of any type of 2D array
	public static <E> void print2DArrayElement(E[][] inputArray)
	{
		for (E[] outerElements : inputArray) 
		{
			for (E innerElements : outerElements) 
			{
				System.out.print(innerElements+" ");
			}
			System.out.println();
		}
	}


	/**
	 * @param arr an array of type integer which has all the user given integers 
	 */
	public static int combineToGetZero(int[] arr)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				for(int k=j+1;k<arr.length;k++)
				{
					if(arr[i]+arr[j]+arr[k]==0)
					{
						count++;
						System.out.println(arr[i]+"+"+arr[j]+"+"+arr[k]);
					}
				}
			}
		}
		return count;

	}

	/**
	 * @param firstPoint the point from which the distance will be calculated
	 * @param secondPoint the point upto which the distance will be calculated
	 */
	public static double calEuclideanDistance(int firstPoint, int secondPoint) 
	{
		double ans=Math.sqrt(Math.pow(firstPoint,2)+Math.pow(secondPoint, 2));
		return ans;
		
	}

	/**
	 * @param firstConstant the constant with X^2 in a quadratic equation
	 * @param secondConstant the constant with X in a quadratic equation
	 * @param lastConstant the last constant
	 */
	public static double[] calRootsOfQuadraticEquation(int firstConstant, int secondConstant, int lastConstant) {
		double[] rootArray=new double[2];
		double delta=secondConstant*secondConstant-(4*firstConstant*lastConstant);
		double root1=0;
		double root2=0;
		double real=0;
		double imaginary=0;
		System.out.println("delta="+delta);
		if(delta>0)
		{
			root1=(-(secondConstant)+Math.sqrt(delta))/(2*firstConstant);
			root1=(-(secondConstant)-Math.sqrt(delta))/(2*firstConstant);
		}
		else if(delta<0)
		{
			root1=(-secondConstant)/(2*firstConstant);
			root2=Math.sqrt((-delta)/(2*firstConstant));
		}
		else if(delta==0)
		{
			root1=root2=(-secondConstant/(2*firstConstant));
		}
		rootArray[0]=root1;
		rootArray[1]=root2;
		return rootArray;
		
	}

	/**
	 * @param tempratureInfahrenheit temprature which is in fahrenheit
	 * @param windSpeedInMilesPerHour speed of wind which is in miles/second
	 * @return
	 */
	public static double defineWeather(double tempratureInfahrenheit, double windSpeedInMilesPerHour) {
		if(tempratureInfahrenheit<50 && ( windSpeedInMilesPerHour<120 ||windSpeedInMilesPerHour>3))
		{
			double weather=35.75 + (0.6215 * tempratureInfahrenheit) + ((0.4275*tempratureInfahrenheit) - 35.75)*Math.pow(windSpeedInMilesPerHour, 0.16);
			return weather;
		}
		else
			return 0.0;
		
	}
	
	
	/**
	 * @param maximum the highest value upto which random value will be generated
	 * @param minimum the lowest value starting from which random value will be generated
	 * @return
	 */
	public static int randomWithRange(int maximum,int minimum)
	{
		int range=(maximum-minimum)+1;
		return (int)(Math.random()*range)+minimum;
	}


	/**
	 * @param string whose spaces will be removed
	 * @return String returns a string without space 
	 */
	public static String removeSapce(String string) 
	{
		String temprary="";
		for(int i=0;i<string.length();i++)
		{
			if(string.charAt(i)!=' ')
			{
				temprary=temprary+string.charAt(i);
			}
			
		}
		return temprary;
	}

	/**
	 * @param array1 the sorted array on which searching will be done
	 * @param search1 the element to be searched from the array
	 * @return number the index of the array where the searching element is present 
	 */
	public static int stringBinarySearch(String[] array1, String search1) 
	{
		int low=0;
		int high=array1.length-1;
		int mid=0;
		while(low<=high)
		{
			mid=low+(high-low)/2;
			if(array1[mid].equalsIgnoreCase(search1))
			{
				
				return mid;
			}
			else if(search1.compareToIgnoreCase(array1[mid])>0)
			{
				low=mid+1;
			}
			else if(search1.compareToIgnoreCase(array1[mid])<0)
			{
				high=mid-1;
			}
		}
		
		return -1;
	}
	
	

	/**
	 * @param array1 the sorted array on which searching will be done
	 * @param search1 the element to be searched from the array
	 * @return number the index of the array where the searching element is present 
	 */
	public static <E extends Comparable> int stringBinarySearch(E[] array1, E search1) 
	{
		int low=0;
		int high=array1.length-1;
		int mid=0;
		while(low<=high)
		{
			mid=low+(high-low)/2;
			if(array1[mid].compareTo(search1)==0)
			{
				
				return mid;
			}
			else if(search1.compareTo(array1[mid])>0)
			{
				low=mid+1;
			}
			else if(search1.compareTo(array1[mid])<0)
			{
				high=mid-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * @param array the array to be sorted
	 * @return array the sorted array
	 */
	public static Integer[] intBubbleSort(Integer[] array)
	{
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
					Integer temprary=array[i];
					array[i]=array[j];
					array[j]=temprary;
				}
			}
		}
		return array;
	}

	
	/**
	 * @param array a array to be sorted
	 * @return the sorted array
	 */
	public static <E extends Comparable> E[] bubbleSort(E[] array)
	{
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i].compareTo(array[j])>0)
				{
					E temprary=array[i];
					array[i]=array[j];
					array[j]=temprary;
				}
			}
		}
		return array;
	}

	/**
	 * @param number the number which will be checked for prime
	 * @return true if the given number is prime and false if it is not prime
	 */
	public static boolean isPrime(int number) 
	{
		if(number<2)
		{
			return false;
		}
		for(int i=2;i<=number/2;i++)
		{
			if((number%i)==0)
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * @param number which is to be checked for pallindrome
	 * @return true if the given number is pallindrome,false if it is not
	 */
	public static boolean isPallindrome(int number) 
	{
		int copyNumber=number;
		int reverseNumber=0;
		while(copyNumber>0)
		{
			reverseNumber=reverseNumber*10+(copyNumber%10);
			copyNumber=copyNumber/10;
		}
		return (reverseNumber==number);
		
	}


	/**
	 * @param number1 the first number which will be checked with the second number for anagram
	 * @param number2 the first number which will be checked with the second number for anagram
	 * @return true if the given numbers are anagram
	 */
	public static <T> boolean numAnagramCheck(T number1, T number2) 
	{
		String tempNumber1=number1+"";
		String tempNumber2=number2+"";
		return (Utility.stringBubbleSortByLetter(tempNumber1).equals(Utility.stringBubbleSortByLetter(tempNumber2)));
		
	}
	

	public static <T extends Comparable<T>> T maxOfThree(T x,T y,T z)
	{
		if(x.compareTo(y)>0 && x.compareTo(z)>0)
		{
			return x;
		}
		else if(y.compareTo(x)>0 && y.compareTo(z)>0)
		{
			return y;
		}
		else
			return z;
		
	}
	
	
	/**
	 * @param array a array from which one element will be searched
	 * @param search a searching element which will be searched from the given array
	 * @return number returns the index of the searching element
	 */
	public static int intBinarySearch(Integer[] array,int search)
	{
		
		int low=0;
		int high=array.length-1;
		int mid=0;
		
		while(low<=high)
		{
			mid=(int)(low+(high-low)/2);
			if(array[mid]==search)
			{
				
				return mid;
			}
			else if(search<array[mid])
			{
				high=mid-1;
			}
			else if(search>array[mid])
			{
				low=mid+1;
			}	
		}
		
		return -1;
	}
	
	
	
	/**
	 * @param string the word which is to be sorted
	 * @return the sorted string
	 */
	public static String stringBubbleSortByLetter(String string) 
	{
		char[] array=string.toCharArray();
		char temporary=' ';
		for(int i=0;i<string.length()-1;i++)
		{
			for(int j=0;j<string.length()-1-i;j++)
			{
				if(array[j]>array[j+1])
				{
					temporary=array[j];
					array[j]=array[j+1];
					array[j+1]=temporary;
				}
			}
		}
		string=new String(array);
		return string;
	}
	
	
	/**
	 * @param array an array which is to be sorted
	 * @return array an sorted array
	 */
	
	public static String[] stringInsertionSort(String[] array)
	{
	      for (int i = 1; i <= array.length-1; i++)
	      {
	    	  String value = array[i];
	    	  int hole=i;
	    	  while (hole > 0 && array[hole-1].compareToIgnoreCase(value) > 0)
	    	  {
	    		  array[hole] = array[hole-1];
	    		  hole=hole-1;
	    	  }
	    	  array[hole] = value;

	      }
	      return array;
	}
	
	
	
	/**
	 * @param fileName the location of the file from where the contents will be readed
	 * @return contents of the file
	 */
	public String readAllFromFile(String fileName)
	{
		String line=null;
		String readedFile="";
		try 
		{
			FileReader filereader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(filereader);
			while((line=bufferedReader.readLine())!= null)
			{
				readedFile+=line;
			}
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("your file is not found in the location '"+fileName+"'");
		}
		catch(IOException ioException)
		{
			System.out.println("Error in reading your file '"+fileName+"'");
		}
		return readedFile;
	}
	
	/**
	 * @param fileName
	 * @param content
	 */
	public void writeAllToFile(String fileName, String content)
	{
		try
		{
			FileWriter filewriter=new FileWriter(fileName);
			BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
			bufferedwriter.write(content);
			bufferedwriter.close();
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("your file is not found in the location '"+fileName+"'");
		}
		catch(IOException ioException)
		{
			System.out.println("Error in reading your file '"+fileName+"'");
		}
	}


	/**
	 * @param requiredAmount the amount for which change notes will be calculated
	 */
	public static void giveMinimumChange(int requiredAmount) 
	{
		int[] notesAvailable= {1000,500,100,50,10,5,2,1};
		int i=0;
		int count=0;
		int quotient=0;
		while(requiredAmount>=1)
		{
			quotient=requiredAmount/notesAvailable[i];
			if(quotient>0)
			{
				System.out.println(notesAvailable[i]+"Rs. note="+quotient);
				count=count+quotient;
				requiredAmount=requiredAmount%notesAvailable[i];
			}
			
			i++;
		}
		System.out.println("minimum number of notes required is ="+count);
		
	}


	/**
	 * @param day is date
	 * @param month is month number
	 * @param year is year
	 * @return number a number which specifies day
	 */
	public static int dayOfWeek(int day, int month, int year)
	{
	     int y0 = year - (14 - month) / 12;
	     int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
	     int m0 = month + 12 * ((14 - month) / 12) - 2;
	     int d0 = (day + x + 31 * m0 / 12) % 7;
	     return d0;
	}


	/**
	 * @param decimal the decimal number which is to be converted into binary
	 * @return the binary value of the given decimal which is in type string
	 */
	public static String decimalToBinary(int decimal) 
	{
		String binaryNumberInString="";
		String temporary="";
		int numberOfZeroRequired;
		int number=decimal;
		while(number>=1)
		{
			binaryNumberInString=binaryNumberInString+number%2;
			number=number/2;
		}
		/*if(binaryNumberInString.length()%4!=0 && binaryNumberInString.length()>4)
		{
			numberOfZeroRequired=binaryNumberInString.length()-binaryNumberInString.length()%4;
			binaryNumberInString+=giveZero(numberOfZeroRequired);
		}
		else if(binaryNumberInString.length()%4<4)
		{
			binaryNumberInString+=giveZero(4-(binaryNumberInString.length()));
		}*/
		if(binaryNumberInString.length()>0 && binaryNumberInString.length()<8)
		{
			binaryNumberInString+=giveZero(8-binaryNumberInString.length());
		}
		for(int i=binaryNumberInString.length()-1;i>=0;i--)
		{
			temporary+=binaryNumberInString.charAt(i);
		}
		binaryNumberInString=temporary;
		return binaryNumberInString;
	}


	/**
	 * @param numberOfZeroRequired the number of zeros the user needs
	 * @return returns specified number of zeros in the form of string
	 */
	private static String giveZero(int numberOfZeroRequired)
	{
		String s="";
		for(int i=0;i<numberOfZeroRequired;i++)
		{
			s=s+0;
		}
		return s;
	}

	/**
	 * @param binary the binary number which is in string type, and will converted in decimal value
	 * @return returns decimal value of the given binary
	 */
	public static int binaryToDecimal(String binary)
	{
		int decimal=0;
		int index=0;
		for(int i=binary.length()-1;i>=0;i--)
		{
			if(binary.charAt(i)=='1')
			{
				decimal=decimal+(int)Math.pow(2, index);
			}
			index++;
		}
		return decimal;
	}


	/**
	 * @param c the number whose square root value will be calculated by using newtons method
	 * @return returns the square root value of the given number
	 */
	public static double sqrt(int c) 
	{
		 double t=c;
         double epsilon=1e-15;
         while(Math.abs(t-c/t) > epsilon*t)
         {
             t = (c/t + t)/2;
         }
         return t;
		
	}


	/**
	 * @param principal it is the pricipal amount
	 * @param numberOfYears it is the number of years in which the user have to earn the repay amount
	 * @param rateOfIntrest it is the rate of intrest
	 * @return
	 */
	public static double monthlyPayment(double principal, double numberOfYears, double rateOfIntrest) 
	{
		 double payment=0;
		 double r =rateOfIntrest/(1200);
		 double months=12*numberOfYears;
		 payment= (principal*r)/(1-1/(Math.pow((1+r), months)));
		// System.out.println("The Monthly Payment is : "+payment);
		 return payment;
	}


	/**
	 * @param array the array whose elements will be printed
	 */
	public static <E>void print1DArrayElements(E[] array)
	{
		for(E element:array)
		{
			System.out.print(element+" ");
		}
		
	}
	
	
	

	
	/**
	 * @param array the string type of array which will be sorted
	 * @return returns a sorted array
	 */
	public static String[] stringBubbleSort(String[] array) 
	{
		
		String temprary="";
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1-i;j++)
			{
				if(array[j].compareTo(array[j+1])>0)
				{
					temprary=array[j];
					array[j]=array[j+1];
					array[j+1]=temprary;
				}
			}
		}
		
		return array;
	}
	
	

	/**
	 * @param array the array whose elements will be sorted
	 * @return the sorted array of Integer type
	 */
	public static Integer[] intInsertionSort(Integer[] array)
	{

		
		for(int i=1;i<array.length;i++)
		{
			int key=array[i];
			int j=i-1;
			while(j>=0 && array[j]>key)
			{
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=key;
		}
		
		return array;
	}
	
	
	/**
	 * @param array is the generic type array which will be sorted
	 * @return array which is a sorted array
	 */
	public static <E extends Comparable> E[] insertionSort(E[] array)
	{

		
		for(int i=1;i<array.length;i++)
		{
			E key=array[i];
			int j=i-1;
			while(j>=0 && array[j].compareTo(key)>0)
			{
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=key;
		}
		
		return array;
	}
	
	/**
	 * @param low the lowest value from which search operation starts each time when the method is called
	 * @param high the highest value upto which search operation will continue when the method is called
	 * @return the (index of the element)/index which the user thought of
	 */
	public static int search(int low, int high)
	{
		int mid=low+(high-low)/2;
		if(low<high)
		{
			System.out.println("Is your number in between "+low+" and "+mid);
			if(Utility.retBoolean())
			{
				return search(low,mid);
			}
			else
			{
				return search(mid+1,high);
			}
		}
		else
		{
			System.out.println("the number is "+low);
			return low;
		}
		
		
	}


	/**
	 * @param date is the given date
	 * @param month is the given month number
	 * @param year is the given year
	 * @return returns true if all the arguments are valid and returns false is any argument is invalid
	 */
	public static boolean isValidDate(int date, int month, int year)
	{
		if(date<1 || date >31)
		{
			return false;
		}
		if(month<1 || month>12)
		{
			return false;
		}
		if(month==2)
		{
			if(Utility.checkLeapYear(year).equals("Leap Year"))
				return (date<=29);
			else
				return (date<=28);
		}
		if(month==4 || month==6|| month==9 || month==11)
		{
			return (date<=30);
		}
		return true;
	}


	/**
	 * @param string the string which will be checked for pallindrome nature using deque
	 * @return true if the given string is pallindrome and returns false if not
	 */
	public static boolean checkPallindrome(String string) 
	{
		MyDeque<Character> mydeque=new MyDeque<Character>();
		for(int i=0;i<string.length();i++)
		{
			mydeque.addFront(string.charAt(i));
		}
		int iterationSize=mydeque.size()/2;
		for(int i=0;i<iterationSize;i++)
		{
			if(mydeque.removeFront().equals(mydeque.removeRear()))
				continue;
			else
				return false;
		}
		return true;
	}
	
	/**
	 * @param number
	 * @return
	 */
	public static int factorial(int number)
	{
		int fact=1;
		for(int i=1;i<=number;i++)
		{
			fact=fact*i;
		}
		return fact;
	}


	/**
	 * @param nodes
	 */
	public static int numberOfBinaryTree(int nodes)
	{
		int output=0;
		output=factorial(2*nodes)/(factorial(nodes+1)*factorial(nodes));
		return output;
	}


	/**
	 * @param template
	 * @param regexName
	 * @param firstName
	 * @return
	 */
	public static String replaceOperation(String template, String regexName, String firstName)
	{
		Pattern pattern=Pattern.compile(regexName);
		Matcher matcher=pattern.matcher(template);
		return matcher.replaceAll(firstName);
	}
	
	public static <T extends Comparable<T>> void checkAndAddForOrderedList(T element,MyLinkedList<T> mylinkedlist)
	{
		int count=0;
		for(int i=0;i<mylinkedlist.size();i++)
		{
			if(element.compareTo(mylinkedlist.get(i))>0)
			{
				count++;
				continue;
			}
			mylinkedlist.insert(count, element);
			return;
		}
		mylinkedlist.add(element);
	}
	
	public boolean checkForValidExpression(String expression) 
	{
		MyStack<Character> mystack=new MyStack<Character>();
		char paranthesis;
		for(int i=0;i<expression.length();i++)
		{
			paranthesis=expression.charAt(i);
			if(paranthesis=='(' || paranthesis=='{' || paranthesis=='[')
			{
				mystack.push(paranthesis);
			}
			else
			{
				if(mystack.isEmpty())//({})]
				{
					return false;
				}
				else
				{
					switch (paranthesis)
					{
					case ')':
						if(mystack.peek().equals('('))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					case '}':
						if(mystack.peek().equals('{'))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					case ']':
						if(mystack.peek().equals('['))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					}
				}
			
			}
		
		}
		return true;
	
	}
	
	/*public static void primeAnagramAndNonAnagramIn2DArray(MyLinkedList mylinkedlist)
	{
		MyQueue<Integer> distinctAnagram=new MyQueue<Integer>();
		MyQueue<Integer> distinctNonAnagram=new MyQueue<Integer>();
		for(int i=0;i<mylinkedlist.size()-1;i++)
		{
			for(int j=i+1;j<mylinkedlist.size();j++)
			{
				if(Utility.numAnagramCheck(mylinkedlist.get(i),mylinkedlist.get(j)))
				{

					if(distinctAnagram.search(mylinkedlist.get(i))==false)
					{
						distinctAnagram.enqueue(mylinkedlist.get(i));
					}
					if(distinctAnagram.search(mylinkedlist.get(j))==false)
					{
						distinctAnagram.enqueue(mylinkedlist.get(j));
					}
				}
				else
				{
					if(distinctNonAnagram.search(mylinkedlist.get(i))==false && distinctAnagram.search(mylinkedlist.get(i))==false)
					{
						distinctNonAnagram.enqueue(mylinkedlist.get(i));
					}
					if(distinctNonAnagram.search(mylinkedlist.get(j))==false && distinctAnagram.search(mylinkedlist.get(j))==false)
					{
						distinctNonAnagram.enqueue(mylinkedlist.get(j));
					}
				}
			}
		}
		Integer[][] array=new Integer[2][distinctNonAnagram.size()];
		int anagramQueueSize=distinctAnagram.size();
		for(int i=0;i<anagramQueueSize;i++)
		{
			array[0][i]=distinctAnagram.dequeue();
		}
		int nonAnagramQueueSize=distinctNonAnagram.size();
		for(int j=0;j<nonAnagramQueueSize;j++)
		{
			array[1][j]=distinctNonAnagram.dequeue();
		}
	}*/
	
	
	
	/**This function divide the array elements into single cell
     */
    public static void mergeSort(String[] array, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    /**This function merge the array after comparing the strings
     */
    public static void merge(String array[], int low, int mid, int high) {
        int i, mid1, k = 0, low1;
        //int lengthOfFirstSlave=mid-low+1;
        //int lengthOfSecondSlave=high-mid;
        String[] temp = new String[50];
        low1 = low;
        i = low;
        mid1 = mid + 1;
        while ((low1 <= mid) && (mid1 <= high)) {
            if (array[low1].compareToIgnoreCase(array[mid1]) <= 0) {
                temp[i] = array[low1];
                low1++;
            } else {
                temp[i] = array[mid1];
                mid1++;
            }
            i++;
        }
        if (low1 > mid) {
            for (k = mid1; k <= high; k++) {
                temp[i] = array[k];
                i++;
            }
        } else {
            for (k = low1; k <= mid; k++) {
                temp[i] = array[k];
                i++;
            }
        }
        for (k = low; k <= high; k++) {
            array[k] = temp[k];
        }
    }
    
    
    /**
     * @param object
     * @param filePath
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> void convertJavaToJson(T object,String filePath)
    {
    	ObjectMapper mapper=new ObjectMapper();
    	ObjectWriter writer=mapper.writer(new DefaultPrettyPrinter());
    	try 
    	{
			writer.writeValue(new File(filePath),object);
		}
    	catch (JsonGenerationException e)
    	{
			
			e.printStackTrace();
		} 
    	catch (JsonMappingException e) 
    	{
			
			e.printStackTrace();
		} 
    	catch (IOException e) 
    	{
			
			e.printStackTrace();
		}
    	System.out.println("JSON written to the file");
    }
    
    //only to convert the files
    public static <T> ArrayList<T> convertJsonToListUsingJackson(String filePath, ArrayList list)
    {
    	//ArrayList<T> files = new ArrayList<>();
    	ObjectMapper mapper=new ObjectMapper();
		try 
		{
			list=mapper.readValue(new File(filePath), new TypeReference<ArrayList<T>>() {});
		} 
		catch (IOException e) 
		{
			System.out.println("Address book is empty... first add some persons data");
			e.printStackTrace();
		}
		return list;
    }
    
    
    /**
     * @param filePath
     * @return
     */
    public static ArrayList<String> convertJsonToList(String filePath)
    {
    	JSONParser parser=new JSONParser();
    	ArrayList<String> addressBookList=new ArrayList<>();
    	try
    	{
    		Object obj=parser.parse(new FileReader(filePath));
    		JSONArray addressbookJsonList=(JSONArray)obj;
    		for(Object object : addressbookJsonList)
    		{
    			String addressBookName=object.toString();
    			addressBookList.add(addressBookName);
    		}
    	}catch(Exception e){
    		System.out.println("Error in loading Address Books");
    	}
    	return addressBookList;
    }

    
    	
}

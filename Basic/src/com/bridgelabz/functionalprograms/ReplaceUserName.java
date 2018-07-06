/**
 * ..
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author bridgelabz
 *
 */
public class ReplaceUserName 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String template = "Hello <<UserName>>, How are you?";
		System.out.println(template);
		System.out.println("enter the user name");
		String uname = Utility.retNextLine();
		System.out.println(Utility.replaceUsrName(template,uname));
	}

}

/**
 * Purpose:
 * @author: Bijaya Laxmi Senapati
 * @version: 1.0
 * @since:7/06/2018
 */
package com.bridgelabz.objectorientedprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class UserInterface 
{
	static String fileStorage="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/LISTOFADDRESSBOOK.json";
	public static void main(String[] args) 
	{
		//String fileStorage="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/LISTOFADDRESSBOOK";
		AddressBookManager1 addressBookManager1=new AddressBookManager1(fileStorage);
		showInitialOptions(addressBookManager1);
	}
	public static void showInitialOptions(AddressBookManager1 addressBookManager1)
	{
		System.out.println("Choose one of the options given");
		System.out.println("1.CREATE NEW ADDRESSBOOK\t\t 2.OPEN ADDRESS BOOK\t\t");
		System.out.println("3.VIEW ALL ADDRESS BOOK\t\t 4.DELETE ADDRESS BOOK\t\t 5.EXIT");
		int choice=Utility.retInt();
		switch(choice)
		{
		case 1:
			addressBookManager1.createNewAddressBook();
			break;
		case 2:
			addressBookManager1.viewAllAddressBook();
			System.out.println("enter index of the address book which you want to open");
			int indexOfFileList=Utility.retInt();
			addressBookManager1.openAddressBook(indexOfFileList);
			break;
		case 3:
			addressBookManager1.viewAllAddressBook();
			break;
		case 4:
			addressBookManager1.viewAllAddressBook();
			System.out.println("enter index of the address book which you want to delete");
			int indexOfFileListToDelete=Utility.retInt();
			addressBookManager1.deleteAddressBook(indexOfFileListToDelete);
			break;
		case 5:
			addressBookManager1.quitProgram();
			break;
		default:
		}
	}

}

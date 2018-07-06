package com.bridgelabz.objectorientedprograms;

import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Products> riceDetails=new ArrayList<>();
	private ArrayList<Products> wheatDetails=new ArrayList<>();
	private ArrayList<Products> pulsesDetails=new ArrayList<>();

	public ArrayList<Products> getRiceDetails() {
		return riceDetails;
	}
	public void setRiceDetails(ArrayList<Products> riceDetails) {
		this.riceDetails = riceDetails;
	}
	public ArrayList<Products> getWheatDetails() {
		return wheatDetails;
	}
	public void setWheatDetails(ArrayList<Products> wheatDetails) {
		this.wheatDetails = wheatDetails;
	}
	public ArrayList<Products> getPulsesDetails() {
		return pulsesDetails;
	}
	public void setPulsesDetails(ArrayList<Products> pulsesDetails) {
		this.pulsesDetails = pulsesDetails;
	}

}

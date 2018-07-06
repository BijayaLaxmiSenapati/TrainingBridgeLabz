/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

public class StocksPojo 
{
	private String stockName;
	private long numOfShares;
	public String getStockName()
	{
		return stockName;
	}
	public void setStockName(String stockName)
	{
		this.stockName = stockName;
	}
	public long getNumOfShares()
	{
		return numOfShares;
	}
	public void setNumOfShares(long numOfShares)
	{
		this.numOfShares = numOfShares;
	}
	public long getEachSharePrice()
	{
		return eachSharePrice;
	}
	public void setEachSharePrice(long eachSharePrice)
	{
		this.eachSharePrice = eachSharePrice;
	}
	private long eachSharePrice;
	
}

/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class StockReport
{
	static StockPortfolio stockPortfolio=new StockPortfolio();
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException
	{
		String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/stockObject.json";
		System.out.println("Enter how many stocks are there in the market");
		int numOfStocks=Utility.retInt();
		for(int i=0;i<numOfStocks;i++)
		{
			Stock stockObj=new Stock();
			System.out.println("Enter the "+i+"th stock name");
			stockObj.setStockName(Utility.retNext());
			System.out.println("Enter total number of shares in "+stockObj.getStockName()+" stock");
			stockObj.setNumberOfShares(Utility.retInt());
			System.out.println("Enter price of each share");
			stockObj.setSharePrice(Utility.retInt());
			stockPortfolio.getArraylist().add(stockObj);
		}
		Utility.convertJavaToJson(stockPortfolio, filePath);
		
		JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject)object;
		JSONArray arraylist=(JSONArray)jsonObject.get("arraylist");
		long eachStockValue=0;
		long totalStockValue=0;
		for(int i=0;i<arraylist.size();i++)
		{
			JSONObject object1=(JSONObject)arraylist.get(i);
			eachStockValue+=((long)object1.get("numberOfShares"))*((long)object1.get("sharePrice"));
			totalStockValue+=eachStockValue;
			System.out.println("Stock value of "+object1.get("stockName")+" is "+eachStockValue);
			eachStockValue=0;
		}
		System.out.println("Total stock value is "+totalStockValue);
	}
}

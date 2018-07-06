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

public class InventoryManager 
{
	static Inventory inventoryObj=new Inventory();
	static final String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/inventory.json";
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		System.out.println("enter how many types of rice you want to store in the inventory");
		int numberRice=Utility.retInt();
		Products rice=new Products();
		for(int i=0;i<numberRice;i++)
		{
			rice=makeRiceObject();
			inventoryObj.getRiceDetails().add(rice);
		}
		System.out.println("enter how many types of wheat you want to store in the inventory");
		int numberWheat=Utility.retInt();
		Products wheat=new Products();
		for(int i=0;i<numberWheat;i++)
		{
			wheat=makeRiceObject();
			inventoryObj.getWheatDetails().add(wheat);
		}
		System.out.println("enter how many types of pulses you want to store in the inventory");
		int numberPulses=Utility.retInt();
		Products pulses=new Products();
		for(int i=0;i<numberPulses;i++)
		{
			pulses=makeRiceObject();
			inventoryObj.getPulsesDetails().add(pulses);
		}
		
		Utility.convertJavaToJson(inventoryObj,filePath);
		
		
		JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject)object;
		JSONArray riceArray=(JSONArray)jsonObject.get("riceDetails");
		long totalRiceCost = 0;
		for(int i=0;i<riceArray.size();i++)
		{
			JSONObject object1=(JSONObject)riceArray.get(i);
			totalRiceCost+=(long)object1.get("weight")*(long)object1.get("price");
		}
		
		JSONArray wheatArray=(JSONArray)jsonObject.get("wheatDetails");
		long totalWheatCost = 0;
		for(int i=0;i<wheatArray.size();i++)
		{
			JSONObject object2=(JSONObject)wheatArray.get(i);
			totalWheatCost+=(long)object2.get("weight")*(long)object2.get("price");
		}
		
		JSONArray pulsesArray=(JSONArray)jsonObject.get("pulsesDetails");
		long totalPulsesCost = 0;
		for(int i=0;i<pulsesArray.size();i++)
		{
			JSONObject object3=(JSONObject)pulsesArray.get(i);
			totalPulsesCost+=(long)object3.get("weight")*(long)object3.get("price");
		}
		
		
		System.out.println("Total cost of rice is:"+totalRiceCost);
		System.out.println("Total cost of rice is:"+totalWheatCost);
		System.out.println("Total cost of rice is:"+totalPulsesCost);
	}
	
	
	
	/**
	 * @return
	 */
	public static Products makeRiceObject()
	{
		Products rice=new Products();
		System.out.println("Enter the name");
		String name=Utility.retNext();
		rice.setName(name);
		System.out.println("enter weight");
		long weight=Utility.retLong();
		rice.setWeight(weight);
		System.out.println("enter price per kg of the type");
		long price=Utility.retLong();
		rice.setPrice(price);
		return rice;
	}
	
	
}

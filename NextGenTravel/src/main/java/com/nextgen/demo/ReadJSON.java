package com.nextgen.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * #1 This is the first file I created
 * 
 * Goal #1: Was to read through the given JSON file. 
 * I was able to achieve this goal. However, shortly after I had to figure how to output it on a webpage.
 */
public class ReadJSON 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("canadianCheeseDirectory.json"))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject cheese = (JSONObject) obj;
			System.out.println(cheese);
			
			JSONArray cheeseList = (JSONArray) cheese.get("CheeseDirectory");
			System.out.println(cheeseList);
			
			//Iterate over cheese array
			//cheeseList.forEach( emp -> parseCheeseObject( (JSONObject) emp ) );
			Iterator<JSONObject> iterator = cheeseList.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				i++;
			}
			System.out.println(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * UNUSED *
	 * 
	 * Retrieve cheese from JSON file
	 */
	/*private static void parseCheeseObject(JSONObject cheese) 
	{
		JSONObject cheeseObject = (JSONObject) cheese.get("CheeseDirectory");

		String cheeseId = (String) cheeseObject.get("CheeseId");	
		System.out.println(cheeseId);

		String cheeseNameEn = (String) cheeseObject.get("CheeseNameEn");	
		System.out.println(cheeseNameEn);

		String cheeseNameFr = (String) cheeseObject.get("cheeseNameFr");	
		System.out.println(cheeseNameFr);

		String ManufacturerNameEn = (String) cheeseObject.get("ManufacturerNameEn");
		
		String ManufacturerNameFr = (String) cheeseObject.get("ManufacturerNameFr");
		
		String ManufacturerProvCode = (String) cheeseObject.get("ManufacturerProvCode");
		
		String ManufacturingTypeEn = (String) cheeseObject.get("ManufacturingTypeEn");
		
		String ManufacturingTypeFr = (String) cheeseObject.get("ManufacturingTypeFr");
		
		String WebSiteEn = (String) cheeseObject.get("WebSiteEn");
		
		String WebSiteFr = (String) cheeseObject.get("WebSiteFr");
		
		String FatContentPercent = (String) cheeseObject.get("FatContentPercent");
		
		String MoisturePercent = (String) cheeseObject.get("MoisturePercent");
		
		String ParticularitiesEn = (String) cheeseObject.get("ParticularitiesEn");
		
		String ParticularitiesFr = (String) cheeseObject.get("ParticularitiesFr");
		
		String FlavourEn = (String) cheeseObject.get("FlavourEn");
		
		String FlavourFr = (String) cheeseObject.get("FlavourFr");
		
		String CharacteristicsEn = (String) cheeseObject.get("CharacteristicsEn");
		
		String CharacteristicsFr = (String) cheeseObject.get("CharacteristicsFr");
		
		String RipeningEn = (String) cheeseObject.get("RipeningEn");
		
		String RipeningFr = (String) cheeseObject.get("RipeningFr");
		
		String Organic = (String) cheeseObject.get("Organic");
		
		String CategoryTypeEn = (String) cheeseObject.get("CategoryTypeEn");
		
		String CategoryTypeFr = (String) cheeseObject.get("CategoryTypeFr");
		
		String MilkTypeEn = (String) cheeseObject.get("MilkTypeEn");
		
		String MilkTypeFr = (String) cheeseObject.get("MilkTypeFr");
		
		String MilkTreatmentTypeEn = (String) cheeseObject.get("MilkTreatmentTypeEn");
		
		String MilkTreatmentTypeFr = (String) cheeseObject.get("MilkTreatmentTypeFr");
		
		String RindTypeEn = (String) cheeseObject.get("RindTypeEn");
		
		String RindTypeFr = (String) cheeseObject.get("RindTypeFr");
		
		String LastUpdateDate = (String) cheeseObject.get("LastUpdateDate");
	}*/
}

package com.nextgen.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CheeseService {

	public List getCheeseBasedOnLanguage(LanguageType lang) {
		List cheeses = new ArrayList();

		if(lang.equals(LanguageType.en)) {
			cheeses = getCheeses();
		}
		if(lang.equals(LanguageType.fr)) {

		}

		return cheeses;
	}
	public List getCheeses() {
		List list = new ArrayList();
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

			list = cheeseList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

package com.gwhitton.foursquareapi.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParserUtil {

	public static List<String> getValues(String json, String subArrayName, String key) throws JasonParserUtilException{

		try{

			List<String> result = new ArrayList<>();
			JSONObject obj = new JSONObject(json);
			JSONObject responseObject = obj.getJSONObject("response");
			JSONArray arr = responseObject.getJSONArray(subArrayName);
			
			for (int i = 0; i < arr.length(); i++)
			{
				result.add(arr.getJSONObject(i).getString(key));
			}

			return result;

		} catch (Throwable t){
			throw new JasonParserUtilException(t);
		}
	}
}

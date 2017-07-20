package com.gwhitton.foursquareapi.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParserUtil {

	/**
	 * Returns values found in JSON as a list of Strings
	 * 
	 * @param json a correctly formatted JSON string
	 * @param subArrayName e.g. in {"level0": {"level1": "name"}}, search for level1
	 * @param key the key to search for in the given subArray
	 * @return
	 * @throws JasonParserUtilException
	 */
	public static List<String> getValues(String json, String subArrayName, String key) throws JasonParserUtilException{

		if(json == null || subArrayName == null || key == null){
			throw new IllegalArgumentException("parameter is null");
		}
		
		if(json.isEmpty() || subArrayName.isEmpty() || key.isEmpty()){
			throw new IllegalArgumentException("parameter is empty");
		}
		
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

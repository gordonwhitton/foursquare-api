package com.gwhitton.foursquareapi.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JsonParserUtilTest {

	@Test
	public void testGetValues() throws JasonParserUtilException {

		String json = "{\"response\": {\"venues\": [{\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}}";

		List<String> result = JsonParserUtil.getValues(json, "venues", "name");

		for(String s : result){
			System.out.println(s);
		}
	}

}

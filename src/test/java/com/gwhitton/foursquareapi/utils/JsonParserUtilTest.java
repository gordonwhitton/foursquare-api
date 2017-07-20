package com.gwhitton.foursquareapi.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonParserUtilTest {

	private static final String BASIC_JSON = 
			"{\"response\": {\"venues\": [{\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}}";

	private static final String INVALID_JSON_1 = 
			"{\"response\": \"venues\": [{\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}}";
	
	private static final String INVALID_JSON_2 = 
			"{\"response\": \"venues\": {\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}}";
	
	private static final String INVALID_JSON_3 = 
			"{\"response\": \"venues\": [{\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesNull1() throws JasonParserUtilException {
		JsonParserUtil.getValues(null, "venues", "name");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesNull2() throws JasonParserUtilException {
		JsonParserUtil.getValues(BASIC_JSON, null, "name");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesNull3() throws JasonParserUtilException {
		JsonParserUtil.getValues(BASIC_JSON, "venues", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesNull4() throws JasonParserUtilException {
		JsonParserUtil.getValues(null, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesEmpty1() throws JasonParserUtilException {
		JsonParserUtil.getValues("", "venues", "name");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesEmpty2() throws JasonParserUtilException {
		JsonParserUtil.getValues(BASIC_JSON, "", "name");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesEmpty3() throws JasonParserUtilException {
		JsonParserUtil.getValues(BASIC_JSON, "venues", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuesEmpty4() throws JasonParserUtilException {
		JsonParserUtil.getValues("", "", "");
	}
	
	@Test
	public void testGetValues() throws JasonParserUtilException {
		List<String> result = JsonParserUtil.getValues(BASIC_JSON, "venues", "name");
		assertTrue(result.contains("name1")&&result.contains("name2")&&result.contains("name3")&&result.size() == 3);
	}
	
	@Test(expected = JasonParserUtilException.class)
	public void testGetValuesInvalidJson1() throws JasonParserUtilException {
		JsonParserUtil.getValues(INVALID_JSON_1, "venues", "name");
	}
	
	@Test(expected = JasonParserUtilException.class)
	public void testGetValuesInvalidJson2() throws JasonParserUtilException {
		JsonParserUtil.getValues(INVALID_JSON_2, "venues", "name");
	}
	
	@Test(expected = JasonParserUtilException.class)
	public void testGetValuesInvalidJson3() throws JasonParserUtilException {
		JsonParserUtil.getValues(INVALID_JSON_3, "venues", "name");
	}
}

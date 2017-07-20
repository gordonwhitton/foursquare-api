package com.gwhitton.foursquareapi.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonParserUtilTest {

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
	
	@Test
	public void testGetValues() throws JasonParserUtilException {
		String json = "{\"response\": {\"venues\": [{\"name\": \"name1\"},{\"name\": \"name2\"},{\"name\": \"name3\"}]}}";
		List<String> result = JsonParserUtil.getValues(json, "venues", "name");
		assertTrue(result.contains("name1")&&result.contains("name2")&&result.contains("name3")&&result.size() == 3);
	}
}

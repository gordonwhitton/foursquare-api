package com.gwhitton.foursquareapi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestCallerTest {

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
	public void testPerformGet() throws RestCallerException {
		
		String url = "https://api.foursquare.com/v2/venues/search?near=Chicago";
		String result = RestCaller.performGet(url);
		
		System.out.println(result);
		
		//fail("Not yet implemented");
	}

}

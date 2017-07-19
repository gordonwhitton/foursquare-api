package com.gwhitton.foursquareapi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FourSquareApiTest {

	private FourSquareApi api;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		api = new FourSquareApi();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetVenuesNull() {
		String location = null;
		api.getVenues(location);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetVenuesEmpty() {
		String location = "";
		api.getVenues(location);
	}
}

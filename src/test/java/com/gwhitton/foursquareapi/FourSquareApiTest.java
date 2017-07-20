package com.gwhitton.foursquareapi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FourSquareApiTest {

	private static FourSquareApi api;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		api = new FourSquareApi("CLIENT_ID", "CLIENT_SECRET");
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
	public void testContsructorNull1() throws FourSquareApiException {
		new FourSquareApi(null, "CLIENT_SECRET");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContsructorNull2() throws FourSquareApiException {
		new FourSquareApi("CLIENT_ID", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContsructorNull3() throws FourSquareApiException {
		new FourSquareApi(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContsructorEmpty1() throws FourSquareApiException {
		new FourSquareApi("", "CLIENT_SECRET");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContsructorEmpty2() throws FourSquareApiException {
		new FourSquareApi("CLIENT_ID", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContsructorEmpty3() throws FourSquareApiException {
		new FourSquareApi("", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetVenuesNull() throws FourSquareApiException {
		String location = null;
		api.getVenues(location);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetVenuesEmpty() throws FourSquareApiException {
		String location = "";
		api.getVenues(location);
	}
	
	//TODO with more time I would use a mocking framework to add further tests for the API, specifically to mock
	//objects which require an internet connection
}

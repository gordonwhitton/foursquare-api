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
		
		final String CLIENT_ID = "FQUQDZ3UCYKME5UFS0ZB0DH2FJA0X34CYDYQNTUG5JR5PQDK";
		final String CLIENT_SECRET = "5ECN0LW0F4S4P5GU0K4VMQTJS1204G2YICWQ1HRNYWC0HEWJ";
		
		//String url = "https://api.foursquare.com/v2/venues/search?oauth_token=ACCESS_TOKEN&near=Chicago";
		//String url = "https://api.foursquare.com/v2/venues/search?client_id=433756101&client_secret=Maidenhead2016#&near=Chicago";
		String url = String.format("https://api.foursquare.com/v2/venues/search?near=Chicago&client_id=%s&client_secret=%s", CLIENT_ID, CLIENT_SECRET);

		String result = RestCaller.performGet(url);
		
		System.out.println(result);
		
		//fail("Not yet implemented");
	}

}

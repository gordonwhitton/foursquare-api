package com.gwhitton.foursquareapi.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gwhitton.foursquareapi.utils.RestCaller;
import com.gwhitton.foursquareapi.utils.RestCallerException;

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
		
		final String VERSION = "20170719";
		final String MODE = "foursquare";
		
		String url = String.format("https://api.foursquare.com/v2/venues/search?near=Chicago&client_id=%s&client_secret=%s&v=%s&m=%s", CLIENT_ID, CLIENT_SECRET, VERSION, MODE);

		String result = RestCaller.performGet(url);
		
		System.out.println(result);
		
		//fail("Not yet implemented");
	}

}

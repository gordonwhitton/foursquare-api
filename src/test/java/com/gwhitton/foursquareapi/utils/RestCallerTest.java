package com.gwhitton.foursquareapi.utils;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gwhitton.foursquareapi.utils.RestCaller;
import com.gwhitton.foursquareapi.utils.RestCallerException;

public class RestCallerTest {

	private static String clientID;
	private static String clientSecret;
	private static String version;
	private static String mode;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		prop.load(input);

		clientID = prop.getProperty("clientID");
		clientSecret = prop.getProperty("clientSecret");
		version = prop.getProperty("version");
		mode = prop.getProperty("mode");
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

	/**
	 * This test requires internet connectivity
	 * 
	 * @throws RestCallerException
	 */
	@Test
	public void testPerformGet() throws RestCallerException {
		String url = String.format("https://api.foursquare.com/v2/venues/search?near=Chicago&client_id=%s&client_secret=%s&v=%s&m=%s", 
				clientID, clientSecret, version, mode);
		String result = RestCaller.performGet(url);
		assertTrue(isJSONValid(result));
	}
	
	private static boolean isJSONValid(String json) {
	    try {
	        new JSONObject(json);
	    } catch (JSONException ex) {
	        try {
	            new JSONArray(json);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}

}

package com.gwhitton.foursquareapi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestCaller {

	//based on example from https://www.mkyong.com/java/apache-httpclient-examples/

	private static final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * Performs HTTP GET on given URL.
	 * 
	 * @param url
	 * @return String with JSON
	 * @throws RestCallerException
	 */
	public static String performGet(String url) throws RestCallerException{

		if(url == null){
			throw new IllegalArgumentException("parameter is null");
		}
		
		if(url.isEmpty()){
			throw new IllegalArgumentException("parameter is empty");
		}
		
		StringBuffer result = new StringBuffer();
		
		try{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

		} catch (Throwable t){
			throw new RestCallerException(t);
		}
		
		return result.toString();
	}
}

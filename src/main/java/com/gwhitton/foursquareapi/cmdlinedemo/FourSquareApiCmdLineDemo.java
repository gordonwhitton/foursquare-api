package com.gwhitton.foursquareapi.cmdlinedemo;

import java.util.List;

import com.gwhitton.foursquareapi.FourSquareApi;
import com.gwhitton.foursquareapi.FourSquareApiException;

/**
 * 
 * An example command line application to demo how to use the FourSquareApi
 * 
 * @author Gordon
 *
 */
public class FourSquareApiCmdLineDemo {

	/**
	 * pass the following three arguments
	 * 
	 * clientID e.g. 12345
	 * clientSecret e.g. 67890
	 * location e.g. London
	 * 
	 * @param args
	 * @throws FourSquareApiException 
	 */
	public static void main(String[] args) throws FourSquareApiException {

		if(args.length != 3){
			throw new IllegalAccessError("cmd line format should be three args, client ID, clientSecret, and location");
		}
		
		String clientID = args[0];
		String clientSecret = args[1];
		FourSquareApi api = new FourSquareApi(clientID, clientSecret);
		
		String location = args[2];
		List<String> venues = api.getVenues(location);
		
		for(String s : venues){
			System.out.println(s);
		}
	}
}

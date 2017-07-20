package com.gwhitton.foursquareapi;

import java.util.ArrayList;
import java.util.List;

import com.gwhitton.foursquareapi.utils.RestCaller;
import com.gwhitton.foursquareapi.utils.RestCallerException;

/**
 * 
 * An API wrapper to access Foursquare data, via their REST services
 * 
 * @author Gordon
 *
 */
public class FourSquareApi {
	
	private static final String FOURSQUARE_VENUES_SEARCH_URL = 
			"https://api.foursquare.com/v2/venues/search?near=%s&client_id=%s&client_secret=%s&v=%s&m=%s";
	private static final String VERSION = "20170719";
	private static final String MODE = "foursquare";
	
	private String clientID;
	private String clientSecret;


	
	public FourSquareApi(String clientID, String clientSecret){
		
		if(clientID == null || clientSecret == null){
			throw new IllegalArgumentException("parameter is null");
		}
		
		if(clientID.isEmpty() || clientSecret.isEmpty()){
			throw new IllegalArgumentException("parameter is empty");
		}
		
		this.clientID = clientID;
		this.clientSecret = clientSecret;
	}

	/**
	 * Returns a list of venues based upon the given location
	 * 
	 * @param location
	 * @return
	 * @throws FourSquareApiException 
	 */
	public List<String> getVenues(String location) throws FourSquareApiException{

		if(location == null){
			throw new IllegalArgumentException("location is null");
		}
		
		if(location.isEmpty()){
			throw new IllegalArgumentException("location is empty");
		}
		
		String url = String.format(FOURSQUARE_VENUES_SEARCH_URL, location, clientID, clientSecret, VERSION, MODE);

		String jsronResult; 
		try {
			jsronResult = RestCaller.performGet(url);
		} catch (RestCallerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FourSquareApiException(e);
		}
		
		List<String> result = new ArrayList<>();
		
		//TODO perform REST query here
		
		return result;
	}
}

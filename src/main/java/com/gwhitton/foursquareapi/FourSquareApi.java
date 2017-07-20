package com.gwhitton.foursquareapi;

import java.util.List;

import com.gwhitton.foursquareapi.utils.JsonParserUtil;
import com.gwhitton.foursquareapi.utils.JsonParserUtilException;
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
	
	private static final String VENUES_NAME_KEY = "name";
	private static final String VENUES_SUB_ARRAY = "venues";
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

		try {
			String jsronResult = RestCaller.performGet(url);
			return JsonParserUtil.getValues(jsronResult, VENUES_SUB_ARRAY, VENUES_NAME_KEY);
		} catch (RestCallerException | JsonParserUtilException e) {
			throw new FourSquareApiException(e);
		}
	}
}

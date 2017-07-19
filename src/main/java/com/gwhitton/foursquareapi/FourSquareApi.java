package com.gwhitton.foursquareapi;

import java.util.ArrayList;
import java.util.List;

public class FourSquareApi {

	//initial approach - attempt to access FourSquare REST api, with the intention of refactoring later
	
	//see https://developer.foursquare.com/docs/venues/search
	
	public List<String> getVenues(String location){

		if(location == null){
			throw new IllegalArgumentException("location is null");
		}
		
		if(location.isEmpty()){
			throw new IllegalArgumentException("location is empty");
		}
		
		List<String> result = new ArrayList<>();
		
		//TODO perform REST query here
		
		return result;
	}
}

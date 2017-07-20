package com.gwhitton.foursquareapi;

import com.gwhitton.foursquareapi.utils.RestCallerException;

public class FourSquareApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5724071612949481179L;

	public FourSquareApiException(RestCallerException e) {
		super(e);
	}
}

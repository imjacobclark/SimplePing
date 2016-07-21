package com.uk.jacob.service;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uk.jacob.adapter.HttpAdapter;
import com.uk.jacob.model.PingResponse;

@Component
public class PingerService {
	
	@Autowired
	HttpAdapter httpAdapter;
	
	@Autowired
	PingResponse pingResponse;

	public PingResponse ping(final String urlToPing) {	
		pingResponse.url = urlToPing;
		pingResponse.responseCode = 0;

		try {
			HttpURLConnection connection = httpAdapter.createHttpURLConnection(urlToPing);

			pingResponse.response = true;
			pingResponse.responseCode = connection.getResponseCode();
		} catch (Exception exceptionMessage) {
			pingResponse.response = false;
			pingResponse.message = exceptionMessage.getMessage();
		}
		
		return pingResponse;
	}
}

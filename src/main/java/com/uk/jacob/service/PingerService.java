package com.uk.jacob.service;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uk.jacob.adapter.HttpAdapter;
import com.uk.jacob.model.WebsiteResponseModel;

@Component
public class PingerService {
	
	@Autowired
	HttpAdapter httpAdapter;
	
	@Autowired
	WebsiteResponseModel website;

	public WebsiteResponseModel ping(String urlToPing) {	
		website.url = urlToPing;
		website.responseCode = 0;

		try {
			HttpURLConnection connection = httpAdapter.createHttpURLConnection(urlToPing);

			website.response = true;
			website.responseCode = connection.getResponseCode();
		} catch (Exception exceptionMessage) {
			website.response = false;
			website.message = exceptionMessage.getMessage();
		}
		
		return website;
	}
}

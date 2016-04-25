package com.uk.jacob.service;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uk.jacob.adapter.HttpAdapter;
import com.uk.jacob.model.Website;

@Component
public class PingerService {
	
	@Autowired
	HttpAdapter httpAdapter;
	
	@Autowired
	Website website;

	public Website ping(String urlToPing) {	
		website.url = urlToPing;
		website.responseCode = 0;

		try {
			HttpURLConnection connection = httpAdapter.createHttpURLConnection(urlToPing);

			website.response = true;
			website.responseCode = connection.getResponseCode();
		} catch (Exception e) {
			website.response = false;
		}
		
		return website;
	}
}

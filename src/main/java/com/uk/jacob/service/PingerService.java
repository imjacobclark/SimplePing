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
		try {
			HttpURLConnection connection = httpAdapter.createHttpURLConnection(urlToPing);

			if(connection.getResponseCode() == 200){
				website.ok = true;
			}else{
				website.ok = false;
			}
		} catch (Exception e) {
			website.ok = false;
		}
		
		return website;
	}
}

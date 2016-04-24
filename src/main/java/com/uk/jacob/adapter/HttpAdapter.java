package com.uk.jacob.adapter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class HttpAdapter {
	public HttpURLConnection createHttpURLConnection(String urlToPing) throws IOException{
		URL url = new URL(urlToPing);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.connect();
		
		return connection;
	}
}

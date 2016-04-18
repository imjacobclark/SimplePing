package com.uk.jacob.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.uk.jacob.model.Ping;

public class PingerService {

	public Ping ping(String urlToPing) {
		Ping ping = new Ping();
		
		try {
			HttpURLConnection connection = getConnectionHandler(urlToPing);

			if(connectionIsOk(connection)){
				ping.ok = true;
			}
		} catch (Exception e) {
			ping.ok = false;
		}
		
		return ping;
	}

	private boolean connectionIsOk(HttpURLConnection connection) throws IOException {
		return connection.getResponseCode() == 200;
	}

	private HttpURLConnection getConnectionHandler(String urlToPing) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(urlToPing);
		HttpURLConnection connection = (HttpURLConnection)
				
		url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		return connection;
	}

}

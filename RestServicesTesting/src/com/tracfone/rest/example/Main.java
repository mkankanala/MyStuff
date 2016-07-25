package com.tracfone.rest.example;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {

//	private static String appToken = "269577746572708|ISDVOVjmpvvmu2q7w4aeZWwV7l0";
//	private static String appId = "269577746572708";
	
	private static String appToken = "1768147223462987|099c9b866b3af74d032bf5e9390d760a";
	private static String appId = "1768147223462987";
	
	
	private static String host = "https://graph.facebook.com/";
	private static String apiUrl = "/accounts/test-users?";
	private static URL finalUrl;
	
	public static void main(String[] args) throws IOException {

		finalUrl = new URL(host + appId + apiUrl + "installed=true" + "&access_token=" + appToken);
		for (int i = 0; i < 2; i++) {
			//System.out.println("User number: " + (i+1));
			sendRequest(true); //Http post request
		}
		
	}

	/**
	 * 
	 * @param type True if it is a POST request
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	private static void sendRequest(boolean type) throws MalformedURLException, IOException,
			ProtocolException {
		HttpURLConnection connection = (HttpURLConnection)finalUrl.openConnection();
		if (type)
			connection.setRequestMethod("POST");
		System.out.println(connection.getURL());
	
		InputStream is = connection.getInputStream();
		String response = IOUtils.toString(is);
		is.close();
		connection.disconnect();
		displayJSON(response);
	}
	
	
	private static void displayJSON(String json) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);

	}

}

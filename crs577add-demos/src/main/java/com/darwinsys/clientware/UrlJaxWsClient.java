package com.darwinsys.clientware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A JAX-WS client NOT using the JAX-WS Client API
 * In fact, not using anything except Core Java APIs.
 */
public class UrlJaxWsClient {

	static final String BASE_URL = 
		"http://androidcookbook.com/rest/recipe";

	public static void main(String[] args) throws Exception {
		
		// IRL this would come from the user, or ??
		final int recipeId = 4;
		
		// String concat, but ints cannot contain injection data
		URL url = new URL(BASE_URL + "/" + recipeId);
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("Accept", "application/json");
		InputStream is = connection.getInputStream();
		// Read "is" to get the response from a GET
		BufferedReader bi = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = bi.readLine()) != null) {
			System.out.println(line);
		}
	}
}
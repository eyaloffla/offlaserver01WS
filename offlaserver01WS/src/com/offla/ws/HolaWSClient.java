package com.offla.ws;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

public class HolaWSClient {
	
	 protected static final Logger logger =
		      Logger.getLogger(HolaWSClient.class.getName());
	 
   protected static final String UTF8 = "UTF-8";
	 
	private final String key = "AIzaSyAS8uZmvqW0RElYSIG6HXGsIzzK-aLrjoM";
	private static final String url = "http://imfpush.ng.bluemix.net/imfpush/v1/apps/82240fb2-5219-477c-8c41-3c8f8b5ccfe1";
	                                  
	//private final String url = "https://gcm-http.googleapis.com/gcm/send";
	
	public static void main(String[] args) throws IOException {
       /* Client c = Client.create();
        WebResource resource = c.resource("http://localhost:9080/offlaserver01WS/rest/holas/otherurl");
        String response = resource.get(String.class);
        System.out.println("Client say: " + response);
        */
		 HolaWSClient hc = new HolaWSClient();
		 hc.post(url, "application/json", "Shalom 01" );
		NotificationSenderWS ns = new NotificationSenderWS();
		System.out.println(ns.message01());
    }
	
	
	public  void post(String url, String contentType, String body)
		      throws IOException {
		    if (url == null || contentType == null || body == null) {
		      throw new IllegalArgumentException("arguments cannot be null");
		    }
		   
		    logger.fine("Sending POST to " + url);
		    logger.finest("POST body: " + body);
		    byte[] bytes = body.getBytes(UTF8);
		    HttpURLConnection conn = getConnection(url);
		    conn.setDoOutput(true);
		    conn.setUseCaches(false);
		    conn.setFixedLengthStreamingMode(bytes.length);
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type", contentType);
		    conn.setRequestProperty("Authorization", "key=" + key);
		    /*
		     * resource.queryParam("appSecret", "35e7b468-78cc-4b94-94e7-6a22841a35ec");
		resource.queryParam("Accept-Language:","en-US");
		resource.queryParam("Application-Mode:","SANDBOX");
		resource.accept(MediaType.APPLICATION_JSON);
		resource.type(MediaType.APPLICATION_JSON);
		     * 
		     */
		    //conn.setRequestProperty("Sender", "id=offla-1117");
		    conn.setRequestProperty("appSecret", "35e7b468-78cc-4b94-94e7-6a22841a35ec");
		    conn.setRequestProperty("Accept-Language", "en-US");
		    conn.setRequestProperty("Application-Mode", "SANDBOX");
		   // conn.setRequestProperty("", "");
		    
		    OutputStream out = conn.getOutputStream();
		    try {
		      out.write(bytes);
		      out.flush();
		      
		      int responseCode = conn.getResponseCode();
		        System.out.println("POST Response Code :: " + responseCode);
		 
		        if (responseCode == HttpURLConnection.HTTP_OK) { //success
		            BufferedReader in = new BufferedReader(new InputStreamReader(
		                    conn.getInputStream()));
		            String inputLine;
		            StringBuffer response = new StringBuffer();
		 
		            while ((inputLine = in.readLine()) != null) {
		                response.append(inputLine);
		            }
		            in.close();
		 
		            // print result
		            System.out.println(response.toString());
		        } else {
		            System.out.println("POST request not worked");
		        }
		      
		      
		    } finally {
		      close(out);
		    }
		    
	    }
	 
		  
	
	 public HttpURLConnection getConnection(String url) throws IOException {
		    return (HttpURLConnection) new URL(url).openConnection();
		  }
	 
	 private static void close(Closeable closeable) {
		    if (closeable != null) {
		      try {
		        closeable.close();
		      } catch (IOException e) {
		        // ignore error
		        logger.log(Level.FINEST, "IOException closing stream", e);
		      }
		    }
		  }

}

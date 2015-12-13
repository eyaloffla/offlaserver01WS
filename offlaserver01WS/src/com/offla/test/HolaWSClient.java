package com.offla.test;




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
	 
	//private final String key = "AIzaSyAS8uZmvqW0RElYSIG6HXGsIzzK-aLrjoM";
	private static final String url = "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
	private static final String message01 = "{ \"message\": { \"alert\":\" This is the new app 01\"}}"; 
	                                  
	
	
	public static void main(String[] args) throws IOException {
       /* Client c = Client.create();
        WebResource resource = c.resource("http://localhost:9080/offlaserver01WS/rest/holas/otherurl");
        String response = resource.get(String.class);
        System.out.println("Client say: " + response);
        */
		 HolaWSClient hc = new HolaWSClient();
		// hc.post(url, "application/json", message01 );
		
		// System.out.println(ns.message02());
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
		    conn.setRequestProperty("appSecret", "3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
		    conn.setRequestProperty("Accept-Language", "en-US");
		    conn.setRequestProperty("Application-Mode", "SANDBOX");
		    
		    OutputStream out = conn.getOutputStream();
		    try {
		      out.write(bytes);
		      out.flush();
		      
		      int responseCode = conn.getResponseCode();
		        System.out.println("POST Response Code :: " + responseCode);
		 
		        if (responseCode == HttpURLConnection.HTTP_ACCEPTED) { 
		            BufferedReader in = new BufferedReader(new InputStreamReader(
		                    conn.getInputStream()));
		            String inputLine;
		            StringBuffer response = new StringBuffer();
		 
		            while ((inputLine = in.readLine()) != null) {
		                response.append(inputLine);
		            }
		            in.close();
		 
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

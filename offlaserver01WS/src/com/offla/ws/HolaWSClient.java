package com.offla.ws;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HolaWSClient {
	
	 protected static final Logger logger =
		      Logger.getLogger(HolaWSClient.class.getName());
	 
   protected static final String UTF8 = "UTF-8";
	 
	private final String key = "AIzaSyAS8uZmvqW0RElYSIG6HXGsIzzK-aLrjoM";
	
	public static void main(String[] args) throws IOException {
       /* Client c = Client.create();
        WebResource resource = c.resource("http://localhost:9080/offlaserver01WS/rest/holas/otherurl");
        String response = resource.get(String.class);
        System.out.println("Client say: " + response);
        */
		 HolaWSClient hc = new HolaWSClient();
		 hc.post("https://gcm-http.googleapis.com/gcm/send", "application/json", "Shalom 01" );
    }
	
	/*
	private static void sender() throws IOException{
		
		final String apiKey = "AIzaSyAS8uZmvqW0RElYSIG6HXGsIzzK-aLrjoM";

		//To make http connection to gcm using following code

		 URL url = new URL("https://gcm-http.googleapis.com/gcm/send");
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type:", "application/json");
		        conn.setRequestProperty("Authorization:", "key="+apiKey);
		       
		        conn.setDoOutput(true);
		        
		        OutputStream out = conn.getOutputStream();
		       // os.write(input.getBytes());
		      //  os.flush();
	          
	    }
	    */
	
	public  void post(String url, String contentType, String body)
		      throws IOException {
		    if (url == null || contentType == null || body == null) {
		      throw new IllegalArgumentException("arguments cannot be null");
		    }
		    if (!url.startsWith("https://")) {
		      logger.warning("URL does not use https: " + url);
		    }
		    logger.fine("Sending POST to " + url);
		    logger.finest("POST body: " + body);
		    byte[] bytes = body.getBytes(UTF8);
		    HttpURLConnection conn = getConnection(url);
		    conn.setDoOutput(true);
		    conn.setUseCaches(false);
		    conn.setFixedLengthStreamingMode(bytes.length);
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type:", contentType);
		    conn.setRequestProperty("Authorization:", "key=" + key);
		    //conn.setRequestProperty("Sender", "id=offla-1117");
		   // conn.setRequestProperty("", "");
		    OutputStream out = conn.getOutputStream();
		    try {
		      out.write(bytes);
		    } finally {
		      close(out);
		    }
		    //return conn;
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

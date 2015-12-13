package com.offla.test;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;


@WebServlet("/NotificationSender")
public class NotificationSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static final Logger logger = Logger.getLogger(HolaWSClient.class.getName());
	private static final String url = "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
	private static final String message01 = "{ \"message\": { \"alert\":\" Shalom 06\"}}"; 
	protected static final String UTF8 = "UTF-8";
  
 
	 
    public NotificationSender() {
        super();
      
    }

	           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	//	post("https://mobile.ng.bluemix.net/imfpush/v1/apps/49500464-58f0-4178-976d-a3d0b3c61170/messages", "application/json", message01 );
		out.println("11"); 
		
		
		
		
		String url= "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
	     String message01= "{ \"message\": { \"alert\":\" Hi There whats up\"}}";

	     org.apache.wink.client.ClientConfig clientConfig= new org.apache.wink.client.ClientConfig();

	     org.apache.wink.client.RestClient client= new org.apache.wink.client.RestClient(clientConfig);
	     org.apache.wink.client.Resource resource= client.resource(url);
	     resource.accept("application/json");
	     resource.acceptLanguage("en-US");
	     resource.contentType(MediaType.APPLICATION_JSON);
	     resource.header("appSecret", "3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
	     resource.header("Application-Mode", "SANDBOX");
	    
	     org.apache.wink.client.ClientResponse resp= resource.post(message01);
	     String msg= (String) resp.getMessage();
	     System.out.println(msg);
	     System.out.println(resp.getStatusCode());
	     System.out.println(resp.getEntity(String.class));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//sendNotification();
		//HolaWSClient hc = new HolaWSClient();
		// hc.post(url, "application/json", message01 );
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//	NotificationSenderClient nsc = new NotificationSenderClient();
	//	nsc.sendNotification();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
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
		    conn.setRequestProperty("Content-Type", contentType);
		    conn.setRequestProperty("Accept","application/json");
		    conn.setRequestProperty("appSecret","3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
		    conn.setRequestProperty("Accept-Language","en-US");
		    conn.setRequestProperty("Application-Mode","SANDBOX");
		    
		   
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
	 
	 private String sendNotification(){
			
		 String url= "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
	     String message01= "{ \"message\": { \"alert\":\" Hi There whats up\"}}";

	     org.apache.wink.client.ClientConfig clientConfig= new org.apache.wink.client.ClientConfig();

	     org.apache.wink.client.RestClient client= new org.apache.wink.client.RestClient(clientConfig);
	     org.apache.wink.client.Resource resource= client.resource(url);
	     resource.accept("application/json");
	     resource.acceptLanguage("en-US");
	     resource.contentType(MediaType.APPLICATION_JSON);
	     resource.header("appSecret", "3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
	     resource.header("Application-Mode", "SANDBOX");
	    
	     org.apache.wink.client.ClientResponse resp= resource.post(message01);
	     String msg= (String) resp.getMessage();
	     System.out.println(msg);
	     System.out.println(resp.getStatusCode());
	     System.out.println(resp.getEntity(String.class));
	     
	     return msg;
	     
		}

}

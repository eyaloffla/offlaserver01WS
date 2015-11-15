package com.offla.ws;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotificationSender
 */
@WebServlet("/NotificationSender")
public class NotificationSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected static final Logger logger =
		      Logger.getLogger(HolaWSClient.class.getName());
	 
  protected static final String UTF8 = "UTF-8";
	 
	private final String key = "AIzaSyAS8uZmvqW0RElYSIG6HXGsIzzK-aLrjoM";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationSender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		post("https://gcm-http.googleapis.com/gcm/send", "application/json", "Shalom 01" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

package com.offla.ws;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.json.java.JSONObject;
import com.offla.entities.GoogleIds;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.config.ClientConfig;
//import com.sun.jersey.api.client.config.DefaultClientConfig;
//import com.sun.jersey.api.client.filter.LoggingFilter;





@Path("/notifications")
public class NotificationSenderWS {
	
  
	
	public NotificationSenderWS(){
		
	}
	
	
	@Path("/callclient")
    @GET
	public String callClient(){
		
		//message02();
		return "call client";
	}
	
	
	 public String message02(){
		 
		/* String url = "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
		 String message01 = "{ \"message\": { \"alert\":\" Hi There whats up\"}}";
		 Client client = Client.create();
		 WebResource resource = client.resource(url);                               
		 resource.addFilter(new LoggingFilter(System.out));
		 //resource.accept(MediaType.APPLICATION_JSON);
		 //resource.type(MediaType.APPLICATION_JSON);
		 resource.header("Content-Type", "application/json;charset=UTF-8");
		 resource.header("Accept", "application/json");
		 resource.header("appSecret","3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
		 resource.header("Accept-Language", "en-US");
		 resource.header("Application-Mode","SANDBOX");
		 */
		 
		 return    "message";                      //resource.post(String.class, message01);

		 
	 }
	
	
	//@Path("/message01")
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
    public String message01(){
    	              
    	//http://imfpush.ng.bluemix.net/imfpush/v1/apps/49500464-58f0-4178-976d-a3d0b3c61170
		  String url = "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
		 // JSONObject jsonObj = new JSONObject();
		 // jsonObj.put("alert", "Shalom");
		  
		   String message01 = "{ \"message\": { \"alert\":\" Shalom 04\"}}"; 
		  
		//  String jsonMessage = jsonObj.toString();
    	
		//  String url = "http://localhost:9080/offlaserver01WS/rest/notificationstestreceptor/message01";
		
		
		//ClientConfig config = new DefaultClientConfig();
	   /* Client client = Client.create();
		WebResource resource =  client.resource(url);                                     //Client.create(new DefaultClientConfig()).resource(url);
		resource.queryParam("appSecret:", "58533377-2567-47db-9b5b-69237b8eb199");
		resource.queryParam("Accept-Language:","en-US");
		resource.queryParam("Application-Mode:","SANDBOX");
		//resource.accept(MediaType.APPLICATION_JSON);
		//resource.type(MediaType.APPLICATION_JSON);
		WebResource.Builder builder = resource.accept(MediaType.APPLICATION_JSON);
	   // builder.type(MediaType.);
		String response = builder.post(String.class, message01);
		
		//builder.header();
		 //conn.setRequestProperty("AString.classccept-Language:","en-US");
		   // conn.setRequestProperty("Application-Mode:","SANDBOX");
		
		return response;*/
		//
		return "hola";
		
		
	}
	

}

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

import com.offla.entities.GoogleIds;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



@Stateless
@LocalBean
//@Path("/notifications")
public class NotificationSenderWS {
	
  
	
	public NotificationSenderWS(){
		
	}
	
	//@Path("/sayhi")
	//@GET
	public String sayHello(){
		
		return "the application said hi 22! " ;
	}
	
	
	//@Path("/message01")
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
    public String message01(){
    	              
    	//http://imfpush.ng.bluemix.net/imfpush/v1/apps/49500464-58f0-4178-976d-a3d0b3c61170
		  String url = "https://mobile.ng.bluemix.net/imfpush/v1/apps/49500464-58f0-4178-976d-a3d0b3c61170/messages";
    	
		//  String url = "http://localhost:9080/offlaserver01WS/rest/notificationstestreceptor/message01";
		
		
		//ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create();
		WebResource resource =  client.resource(url);                                     //Client.create(new DefaultClientConfig()).resource(url);
		resource.queryParam("appSecret", "58533377-2567-47db-9b5b-69237b8eb199");
		resource.queryParam("Accept-Language:","en-US");
		resource.queryParam("Application-Mode:","SANDBOX");
		resource.accept(MediaType.APPLICATION_JSON);
		resource.type(MediaType.APPLICATION_JSON);
		WebResource.Builder builder = resource.accept(MediaType.APPLICATION_JSON);
	    builder.type(MediaType.APPLICATION_JSON);
		String response = builder.post(String.class, "Shalom 01");
		
		//builder.header();
		 //conn.setRequestProperty("AString.classccept-Language:","en-US");
		   // conn.setRequestProperty("Application-Mode:","SANDBOX");
		
		return response;
		//
		//return "hola";
		
		
	}
	

}

package com.offla.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@javax.ws.rs.ApplicationPath("resources")
@Path("/simple")
public class SimpleWS extends javax.ws.rs.core.Application{
	
	@Context
    private UriInfo context;

    @GET
    @Produces("application/xml")
    @Path("/hi")
    public String getXml() {
        return "<xml>Hello Rest World !</xml>";
    }
	
	
	//@Path("/message")
	//public String message(){
	//	return "Shalom";
	//}

}

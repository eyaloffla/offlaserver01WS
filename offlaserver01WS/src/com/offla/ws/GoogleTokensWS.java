package com.offla.ws;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.offla.entities.GoogleIds;

import com.offla.services.IGoogleService;




@Stateless
@LocalBean
@Path("/googletokens")
public class GoogleTokensWS {
	
	@EJB
	IGoogleService service;
	
	@Path("{key}")
	@GET
	public String sayHelloToId(@PathParam(value="key") String key){
		
		GoogleIds g = new GoogleIds();
		g.setAndroidDeviceKey(key);
		g = service.create(g);
		
		return "the token was inserted successfully ! " ;
	}
	
	@Path("/tokens")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<GoogleIds> getAllGoogleIds(){
		
		List<GoogleIds> l = service.getAllGoogleIds();
		for(GoogleIds g : l){
			System.out.println(g.getId() + "  ");
		}
		
		return l;
	}
	
	

}

package com.offla.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.offla.services.IIPWhiteListService;
import com.offla.utils.Util;

@Stateless
@Path("ipaproved")
public class IsIPAproved {
	
	@EJB
	IIPWhiteListService ipWhiteListService;
	
	@GET
	@Path("/ipwhitelist/{ip}")                               
	@Produces("application/json")
	public String isIPAproved(@PathParam(value="ip")String ip){
		
		String result = Util.BOOLEAN_FALSE;
		boolean resultB = false;
		
		resultB = ipWhiteListService.isIPAproved(ip);
		
		if(resultB){
			result = Util.BOOLEAN_TRUE;
		}
		                     
		return result ;
	}

}

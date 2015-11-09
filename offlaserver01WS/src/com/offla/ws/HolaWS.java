package com.offla.ws;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.offla.services.ICellarixTxnLocal;


@Stateless
@LocalBean
@Path("/holas")
public class HolaWS  {
	
	@EJB
	ICellarixTxnLocal bean;
	
	@GET
	public String sayHello() {
        return "Hola como estas ?";
    }
	
	@Path("{id}")
	@GET
	public String sayHelloToId(@PathParam(value="id") int id){
		
		return "the id is: " + id;
	}
	
	@Path("/otherurl")
	@GET
	public String otherWS(){
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time =  sdf.format(cal.getTime());
		return "answer from ws and count phone list: " + bean.getAllCellarixTxn().size() + " at " + time ;
	}

}

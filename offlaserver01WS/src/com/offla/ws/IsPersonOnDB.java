package com.offla.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.offla.services.IAppfr1Service;
import com.offla.utils.Util;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;


@Stateless
@Path("/personexist")
public class IsPersonOnDB {
	
	@EJB
	IAppfr1Service service;
	
	@GET
	@Path("/ispersonondb/{id}/{birthDay}/{finalNumber}")                               
	@Produces("application/json")
	public String isPersonOnDataBase(@PathParam(value="id") String id, @PathParam(value="birthDay") String birthDay, @PathParam(value="finalNumber") String finalNumber){
		long idL = 0;
		long birthdayL = 0;
		long finalNumberL = 0;
		boolean resultB = false;
		String result = Util.BOOLEAN_FALSE;
		
		if(StringUtils.isNotBlank(finalNumber) && !"0".equals(finalNumber)){
			finalNumberL = Util.stringToLong(finalNumber);
		}else{
			idL = Util.stringToLong(id);
			birthdayL = Util.stringToLong(birthDay);
			finalNumberL = idL + birthdayL;
		}
		
	
		resultB = service.isPersonInDB(finalNumberL);
		
		if(resultB){
			result = Util.BOOLEAN_TRUE;
		}
		System.out.println(" The person is on database: " + service.isPersonInDB(finalNumberL));
		
		return result ;                     
	}

	

}

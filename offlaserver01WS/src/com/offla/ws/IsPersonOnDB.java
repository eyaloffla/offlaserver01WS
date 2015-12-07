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
		int idI = 0;
		int birthdayI = 0;
		int finalNumberI = 0;
		boolean resultB = false;
		String result = Util.BOOLEAN_FALSE;
		
		if(StringUtils.isNoneBlank(finalNumber)){
			finalNumberI = Util.stringToInt(finalNumber);
		}else{
			idI = Util.stringToInt(id);
			birthdayI = Util.stringToInt(birthDay);
			finalNumberI = idI + birthdayI;
		}
		
	
		resultB = service.isPersonInDB(finalNumberI);
		
		if(Util.BOOLEAN_TRUE.equals(resultB)){
			result = Util.BOOLEAN_TRUE;
		}
		System.out.println(" The person is on database: " + service.isPersonInDB(finalNumberI));
		
		return result ;                     
	}

	

}

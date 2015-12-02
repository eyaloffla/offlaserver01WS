package com.offla.celarix;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.offla.services.IAppfr1Service;

@Stateless
@LocalBean
public class PersonOnDB {
	
	@EJB
	IAppfr1Service service;
	
	public static void main(String[] args){
		
		PersonOnDB p = new PersonOnDB();
		System.out.println(p.service.isPersonInDB(11111));
		
	}

}

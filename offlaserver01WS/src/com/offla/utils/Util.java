package com.offla.utils;

import org.apache.commons.lang3.StringUtils;


public class Util {

	public static final String BOOLEAN_TRUE = "1";
	public static final String BOOLEAN_FALSE = "0";
	
	
	public static long stringToLong(String id) {
		long idL = 0;
		
		if(StringUtils.isNotBlank(id)){
			
			   idL = Long.valueOf(id);
			   
		}
		return idL;
	}
	
	
	public static boolean isBlankNot(String s){
		boolean b = Boolean.FALSE;
		
		if(!"".equals(s) && s != null & !" ".equals(s)){
			b = Boolean.TRUE;
		}
		
		return b;
	}
	
}

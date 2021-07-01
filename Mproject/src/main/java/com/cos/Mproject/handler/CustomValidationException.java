package com.cos.Mproject.handler;

import java.util.Map;

public class CustomValidationException  extends RuntimeException{

	
	
	private static final long serialVersionUID = 1L;
	

	private Map<String,String> errorMap;
	
	
	
	//Map<String,String> errorMap -> Map<어디서에러,  에러메세지>
	
	
	public CustomValidationException(String message, Map<String,String> errorMap) {
		super(message);
		this.errorMap = errorMap;
	}
	
	
	public Map<String,String> getErrorMap(){
		return errorMap;
	}
}

package com.cos.Mproject.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.Script.Script;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

	
	


		@ExceptionHandler(CustomValidationException.class)
		public String validationException(CustomValidationException e){
				

			if(e.getErrorMap() == null) {
				return Script.back(e.getMessage());
				// 이미지가 등록 확인 익센션 결과 나타내주기 
			}else {
		return  Script.back(e.getErrorMap().toString());}
		}

		
	@ExceptionHandler(CustomValidationApiException.class) // 회원 가입 -> 유효성 검사 
	public ResponseEntity<CMRespDTO<?>> CustomValidationApiException(CustomValidationApiException e) {
	
	return  new  ResponseEntity<>(new CMRespDTO<>(-1,e.getMessage(),e.getErrorMap()),HttpStatus.BAD_REQUEST); // 클라이언트가 받을때는 이렇게 해주는게 맞다 지금은 이렇게 쓰자	
		
		
				
	}

	@ExceptionHandler(CustomApiException.class) // 회원 가입 -> 유효성 검사 
	public ResponseEntity<CMRespDTO<?>> CustomApiException(CustomApiException e) {
	
	return  new  ResponseEntity<>(new CMRespDTO<>(-1,e.getMessage(),null),HttpStatus.BAD_REQUEST); // 클라이언트가 받을때는 이렇게 해주는게 맞다 지금은 이렇게 쓰자	
		
		
				
	}
	
	
	@ExceptionHandler(CustomApiExceptionAlert.class) // 회원 가입 -> 유효성 검사 
	public String CustomApiExceptionAlert(CustomApiExceptionAlert e) {
	
	return Script.back("아이디가 중복 입니다.");
		
				
	}



}

package com.cos.Mproject.web;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.dto.auth.SignUpDto;
import com.cos.Mproject.handler.CustomValidationException;
import com.cos.Mproject.service.AuthService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class AuthController {
	
	
	private final AuthService authService;

	
	@GetMapping("/auth/signin")
	public String signinpage() {
		
	
		return "auth/signin";
	}
	
	
	@GetMapping("/auth/signup")
	public String signuppage() {
		return "auth/signup";
	}
	
	
	@PostMapping("/auth/signup")
	public String signup(@Valid SignUpDto signUpDto, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		
		 Map<String, String> errorMap = new HashMap<String, String>();
		
		for(FieldError error : bindingResult.getFieldErrors()) {
		
			errorMap.put(error.getField(), error.getDefaultMessage());
			 System.out.println(error.getDefaultMessage());//20 이하여야 합니다
			 System.out.println(error.getField()); //username
			 
			 throw new CustomValidationException( "유효성 에러" , errorMap);			
		}}
	
	  User user = signUpDto.toEntity();
	  authService.회원가입(user);
	 
		return "auth/signin";
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}

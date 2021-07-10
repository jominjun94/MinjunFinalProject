package com.cos.Mproject.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.Mproject.Script.Script2;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.domain.user.UserRepository;
import com.cos.Mproject.handler.CustomApiException;
import com.cos.Mproject.handler.CustomApiExceptionAlert;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public void 회원가입(User user) {
		
		
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_USER");
			User userEntity = userRepository.save(user);
		//아이디 중복 예외 처리 기능 
		} catch (DataIntegrityViolationException e) {
			
			throw new CustomApiExceptionAlert("아이디 중복 입니다.");
			
			

	
		}
		
		

		
	}
	
}

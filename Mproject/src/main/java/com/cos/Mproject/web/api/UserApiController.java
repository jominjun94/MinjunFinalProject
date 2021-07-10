package com.cos.Mproject.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.dto.user.UserUpdateDto;
import com.cos.Mproject.handler.CMRespDTO;
import com.cos.Mproject.handler.CustomValidationApiException;
import com.cos.Mproject.service.UserService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
public class UserApiController {

	private final UserService userService;
	
	
	@PutMapping("/api/user/{id}")
	public CMRespDTO<?> update(
			@PathVariable int id,  @Valid UserUpdateDto updateDto, BindingResult bindingResult, 
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		/*/* aop 가 대신 하게 됩니다
		 * if(bindingResult.hasErrors()) { Map<String, String> errorMap = new
		 * HashMap<String, String>();
		 * 
		 * for(FieldError error : bindingResult.getFieldErrors()) {
		 * errorMap.put(error.getField(), error.getDefaultMessage()); }
		 * 
		 * 
		 * throw new CustomValidationApiException("유효성실패",errorMap); }
		 */
		 
		 User userEntity = userService.회원수정(id,updateDto.toEntity());
		 principalDetails.setUser(userEntity);
	
		return new CMRespDTO<>(1,"회원수정완료",userEntity);
		
		
	
}
}
	

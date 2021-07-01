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
			@PathVariable int id,  @Valid UserUpdateDto updateDto, BindingResult bindingResult, // 위치 중요 
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
	
		 if(bindingResult.hasErrors()) { //에러가 나타나면~ 
		 Map<String, String> errorMap = new HashMap<String, String>(); // map을 만들어서~
		 
		  for(FieldError error : bindingResult.getFieldErrors()) { //발생 에러를 에러에 담아~
		  errorMap.put(error.getField(), error.getDefaultMessage()); }
		  
		  
		  throw new CustomValidationApiException("유효성실패",errorMap); }
		 
		 User userEntity = userService.회원수정(id,updateDto.toEntity());
		 principalDetails.setUser(userEntity);
		 // 무한 참조가 걸리게 되서 무한 참조를 막아줘야 합니다	@JsonIgnoreProperties({"user"}) // image 호출시에 user는 호출하지마! -> 무한 참조 방지
		return new CMRespDTO<>(1,"회원수정완료",userEntity);
		
		
	
}
}
	

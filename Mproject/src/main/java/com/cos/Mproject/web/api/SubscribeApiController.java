package com.cos.Mproject.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.handler.CMRespDTO;
import com.cos.Mproject.service.SubscribeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {

	
	private final SubscribeService subscribeService;
	
	@PostMapping("/api/subscribe/{toUserId}")
	public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId){
		int fromUserId = principalDetails.getUser().getId();
		subscribeService.구독하기(fromUserId, toUserId);
		return new ResponseEntity<>(new CMRespDTO<>(1,"구독성공",null),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/api/subscribe/{toUserId}")
	public ResponseEntity<?> unsubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId){
		int fromUserId = principalDetails.getUser().getId();
		int result = subscribeService.구독취소(fromUserId, toUserId);
		return new ResponseEntity<>(new CMRespDTO<>(result,"구독취소성공",null),HttpStatus.OK);
	}
	
}

package com.cos.Mproject.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.image.Image;
import com.cos.Mproject.handler.CMRespDTO;
import com.cos.Mproject.service.ImageService;
import com.cos.Mproject.service.LikesService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class ImageApiController {

	
	private final LikesService likeService;
	private final ImageService imageService;
	
	
	@GetMapping("/api/images")
	public ResponseEntity<?> imageStory(@AuthenticationPrincipal PrincipalDetails principalDetails){
		
		
		 List<Image> images = imageService.구독한사람의이미지(principalDetails.getUser().getId());
		
		 
		 return new ResponseEntity<>(new CMRespDTO<>(1, "성공",images),HttpStatus.OK);

	}
	
	
	@PostMapping("/api/image/{imageId}/likes")
	public ResponseEntity<?> likes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails){
		likeService.좋아요(imageId,principalDetails.getUser().getId());
		
		return new ResponseEntity<>(new CMRespDTO<>(1,"좋아요 성공",null),HttpStatus.OK);
	}

	
	
	@DeleteMapping("/api/image/{imageId}/likes")
	public ResponseEntity<?> nolikes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails){
		likeService.좋아요취소(imageId,principalDetails.getUser().getId());
		
		return new ResponseEntity<>(new CMRespDTO<>(1,"좋아요 취소 성공",null),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/api/image/{imageId}/delete")
	public ResponseEntity<?> deleteImage(@PathVariable int imageId){
		imageService.이미지삭제(imageId);
		
		return new ResponseEntity<>(new CMRespDTO<>(1,"이미지 삭제 성공",null),HttpStatus.OK);
	}
	

	
	
	
	
	

}

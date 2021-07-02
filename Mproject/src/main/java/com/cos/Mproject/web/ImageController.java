package com.cos.Mproject.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.image.Image;
import com.cos.Mproject.dto.image.ImageDto;
import com.cos.Mproject.dto.image.ImageUploadDto;
import com.cos.Mproject.handler.CustomValidationException;
import com.cos.Mproject.service.ImageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImageController {

	private final ImageService imageService;
	
	
	
	
	@GetMapping("/image/upload")
	public String upload() {
		return "image/upload";
		
	}
	
	@PostMapping("/image")
	public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		if(imageUploadDto.getFile().isEmpty()) {
			throw new CustomValidationException("이미지가 없습니다! 이미지를 꼭 첨부해주세용!", null);
		}
		imageService.사진업로드(imageUploadDto, principalDetails);
		int getId = principalDetails.getUser().getId();
		return "redirect:user/"+ getId;
	}
	
	
	@GetMapping("/image/{imageId}")
	public String view(@PathVariable int imageId , Model model,@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		ImageDto imageEntity = imageService.사진가져오기(imageId,principalDetails.getUser().getId());
		model.addAttribute("imagedto",imageEntity);
		return "image/view";
		
	}
	
	@GetMapping("/image/likes")
	public String likeView(Model model) {
		List<Image> imageEntitys = imageService.인기게시글가져오기();
		model.addAttribute("images",imageEntitys);
		return "image/likeView";
	}
	


	
	
}

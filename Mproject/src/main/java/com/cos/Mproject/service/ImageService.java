package com.cos.Mproject.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.image.Image;
import com.cos.Mproject.domain.image.ImageRepository;
import com.cos.Mproject.domain.like.LikesRepository;
import com.cos.Mproject.domain.user.UserRepository;
import com.cos.Mproject.dto.image.ImageDto;
import com.cos.Mproject.dto.image.ImageUploadDto;
import com.cos.Mproject.handler.CustomApiException;
import com.cos.Mproject.handler.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	@Value("${file.path}")
	private String uploadFolder = "C:/Users/82107/Desktop/spring/upload2/";
	
	private final ImageRepository imageRepository;
	
	private final LikesRepository likesRepository;
	
	
	
	public void 사진업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"-"+imageUploadDto.getFile().getOriginalFilename();
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		
		
		
		
		// 통신 예외
		try {
			Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		// DB저장 
		Image imageEntity = imageUploadDto.toEntity(imageFileName, principalDetails.getUser()); 
		imageRepository.save(imageEntity);

		
	}
	
	
	
	@Transactional
	public ImageDto 사진가져오기(int imageId, int userId) {
		Image imageEntity =imageRepository.findById(imageId).orElseThrow(()->{
			
			throw new CustomValidationApiException("해당 프로필은 없는 페이지 입니다.");
		});
		
		
		
		ImageDto dto = new ImageDto();
		
		dto.setLikeState(likesRepository.mLiketrue(imageEntity.getId(),userId) == 1);
		dto.setImage(imageEntity);
		dto.setLikeCount(likesRepository.mLikeCount(imageId));
		dto.setUser(imageEntity.getUser());
		
		return dto;
	}


	@Transactional(readOnly = true)
	public List<Image> 구독한사람의이미지(int pricipalId) {
		 
		 List<Image> images = imageRepository.mImage(pricipalId);
		
		return images;
	}


	@Transactional(readOnly = true)
	public List<Image> 인기게시글가져오기() {
		List<Image> images = imageRepository.mLikeImages();
		return images;
	}


	@Transactional
	public void 이미지삭제(int imageId) {
		
		System.out.println(imageId + "sssssssssssssssssssssssssssssss");
		imageRepository.deleteById(imageId);
		
	}
	
	
	
	
	
}

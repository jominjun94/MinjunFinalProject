package com.cos.Mproject.dto.image;

import org.springframework.web.multipart.MultipartFile;

import com.cos.Mproject.domain.image.Image;
import com.cos.Mproject.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {

	private MultipartFile file;
	private String caption;
	
	public Image toEntity(String postImageUrl ,User user) {
		return Image.builder()
				.caption(caption)
				.postImageUrl(postImageUrl)
				.user(user)
				.build();
	}
}

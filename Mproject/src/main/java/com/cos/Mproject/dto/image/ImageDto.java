package com.cos.Mproject.dto.image;

import com.cos.Mproject.domain.image.Image;
import com.cos.Mproject.domain.user.User;

import lombok.Data;

@Data
public class ImageDto {

	
	private Image image;
	boolean likeState; 
	private int likeCount;
	private User user;
}

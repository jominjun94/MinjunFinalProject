package com.cos.Mproject.dto.image;

import com.cos.Mproject.domain.image.Image;

import lombok.Data;

@Data
public class ImageDto {

	
	private Image image;
	boolean likeState; 
	private int likeCount;
}

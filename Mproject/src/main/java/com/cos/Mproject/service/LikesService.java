package com.cos.Mproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Mproject.domain.like.LikesRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class LikesService {

	private final LikesRepository likeRepository;

	
	@Transactional
	public void 좋아요(int imageId, int id) {
	
		likeRepository.mLikes(imageId,id);
		
	}
	
	
	@Transactional
	public void 좋아요취소(int imageId, int id) {
		
		likeRepository.mUnLikes(imageId,id);
		
	}
	
}

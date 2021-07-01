package com.cos.Mproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Mproject.domain.subscribe.SubscribeRepository;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.handler.CustomApiException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class SubscribeService {

	private final SubscribeRepository subscribeRepository;
	
	@Transactional
	public void 구독하기(int fromUserId , int toUserId) {
		try {
			subscribeRepository.mSubscribe(fromUserId, toUserId);
		} catch (Exception e) {
			throw new CustomApiException("이미 구독 하셨습니다");
		
		}

		
	}
	@Transactional
	public int 구독취소(int fromUserId , int toUserId) {
		int result = subscribeRepository.mUnSubscribe(fromUserId, toUserId);
		return result;
	}
	
	
	public List<Integer> 구독자가져오기(int fromUserId) {
		 subscribeRepository.mSubscribePeople(fromUserId);
		return  subscribeRepository.mSubscribePeople(fromUserId);
	}
	
}

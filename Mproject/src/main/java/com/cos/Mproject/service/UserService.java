package com.cos.Mproject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Mproject.domain.subscribe.SubscribeRepository;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.domain.user.UserRepository;
import com.cos.Mproject.dto.user.UserDto;
import com.cos.Mproject.handler.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final SubscribeRepository subscribeRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDto 회원프로필(int userId, int principalId) {
		User userEntity = userRepository.findById(userId).orElseThrow(() -> {
			throw new CustomValidationApiException("해당 프로필은 없는 페이지 입니다.");
		});

		UserDto dto = new UserDto();

		dto.setSubscribeCount(subscribeRepository.mSubscribeCount(userId));
		dto.setSubscribeState(subscribeRepository.mSubscribeState(principalId, userId) == 1);
		dto.setUser(userEntity);

		return dto;
	}
	
	
	
	
	public User 구독회원(int userId) {
		User userEntity = userRepository.findById(userId).orElseThrow(() -> {
			throw new CustomValidationApiException("해당 프로필은 없는 페이지 입니다.");
		});



		return userEntity;
	}
	
	

	@Transactional
	public User 회원수정(int id, User entity) {

		User findUser = userRepository.findById(id).orElseThrow(() -> {
			return new CustomValidationApiException("찾을수 없는 사용자입니다.");
		});

		findUser.setUsername(entity.getUsername());
		findUser.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		findUser.setName(entity.getName());
		findUser.setEmail(entity.getEmail());
		findUser.setPhone(entity.getPhone());

		return findUser;

	}
	
	
	@Transactional
	public User 회원찾기(String id) {

	 User findUser = userRepository.findByUsername(id);
		return findUser;

	}

}

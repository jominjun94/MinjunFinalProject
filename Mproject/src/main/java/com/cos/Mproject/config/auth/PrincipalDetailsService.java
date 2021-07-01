package com.cos.Mproject.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService{

	
	private final UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userEntity = userRepository.findByUsername(username);
		
		
		if(userEntity == null) {
			throw new RuntimeException("없는 유저입니다.");
		}
		
		return new PrincipalDetails(userEntity);
	}
	
	

}

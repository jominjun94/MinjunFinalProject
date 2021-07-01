package com.cos.Mproject.dto.user;

import javax.persistence.Column;

import com.cos.Mproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdateDto {
	
	
	@Column(length = 100, unique = true ,nullable = false)
	private String username;
	@Column(nullable = false)
	private String  password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	private String phone;
	
	public User toEntity() {
		
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.phone(phone)
				.build();
	}

}

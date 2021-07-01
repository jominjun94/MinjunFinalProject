package com.cos.Mproject.dto.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cos.Mproject.domain.user.User;

import lombok.Data;

@Data
public class SignUpDto {
		
	@NotEmpty(message = "username 입력해주세요")
	@Size(min = 3, max = 20 ,message = "3자~ 20자를 입력해주세요.") // message 안해주면 알아서 나간다 
	private String username;
	@NotEmpty(message = "password 입력해주세요")
	private String password;
	@NotEmpty(message = "email 입력해주세요")
	private String email;
	@NotEmpty(message = "name 입력해주세요")
	private String name;
	
	public User toEntity() {
		
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
	
}

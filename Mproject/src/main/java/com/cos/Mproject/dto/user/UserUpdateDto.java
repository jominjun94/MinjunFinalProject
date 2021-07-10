package com.cos.Mproject.dto.user;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cos.Mproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdateDto {
	
	

	private String username;
	@NotEmpty(message = "password 입력해주세요")
	@Size(min = 4, max = 20 ,message = "4자~ 20자를 입력해주세요.")
	private String  password;
	@NotEmpty(message = "name 입력해주세요")
	private String name;
	@NotEmpty(message = "email 입력해주세요")
	private String email;
	@NotEmpty(message = "phone 입력해주세요")
	@Size(min = 10, max = 11 ,message = "10자~ 11자를 입력해주세요.")
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

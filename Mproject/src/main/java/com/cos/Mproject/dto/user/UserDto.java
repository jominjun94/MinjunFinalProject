package com.cos.Mproject.dto.user;

import com.cos.Mproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

	private User user;
	private boolean subscribeState;
	private int subscribeCount;
}

package com.cos.Mproject.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.cos.Mproject.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, unique = true ,nullable = false)
	private String username;
	@Column(nullable = false)
	private String  password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	private String phone;

	private String profileImageUrl; // 사진
	private String role; // 권한 
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"user"})
	private List<Image> images;
	
	private LocalDateTime createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
	
}

package com.cos.Mproject.domain.board;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import com.cos.Mproject.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content;
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne(fetch= FetchType.EAGER) 
	@JoinColumn(name = "userId")
	private User user;
	
	
	private LocalDateTime createDate;
	
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
	
	
	
	
	
	
	
	
}

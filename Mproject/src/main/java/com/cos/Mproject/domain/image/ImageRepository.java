package com.cos.Mproject.domain.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer>{

	
	
	
	@Query(value = "select * from image where userId in (select toUserId from subscribe where fromUserId = :pricipalId)", nativeQuery = true)
	List<Image> mImage(int pricipalId);

}

package com.cos.Mproject.domain.subscribe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.Mproject.domain.user.User;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer>{

	
	@Modifying
	@Query(value = "INSERT INTO subscribe(fromUserId,toUserId, localDateTime) values(:fromUserId,:toUserId, now())",nativeQuery = true)
	int mSubscribe(int fromUserId, int toUserId);
	
	@Modifying
	@Query(value = "DELETE FROM subscribe where fromUserId = :fromUserId and toUserId = :toUserId", nativeQuery =  true)
	int mUnSubscribe(int fromUserId, int toUserId);


	// 구독자 정보 가져오기
	@Query(value =  "select toUserId from subscribe where fromUserId = :fromUserId", nativeQuery = true)
    List<Integer> mSubscribePeople(int fromUserId);




	// 1 반환시 구독중
	@Query(value = "select count(*) from subscribe where fromUserId = :principalId and toUserId = :pageUserId",nativeQuery = true)
	int mSubscribeState(int principalId, int pageUserId);
	
	//구독자수
	@Query(value = "select count(*) from subscribe where fromUserId  = :pageUserId",nativeQuery = true)
	int mSubscribeCount(int pageUserId);




}

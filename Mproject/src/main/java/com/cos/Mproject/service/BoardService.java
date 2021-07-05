package com.cos.Mproject.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Mproject.domain.board.Board;
import com.cos.Mproject.domain.board.BoardRepository;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.handler.CustomApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	
	private final BoardRepository boardRepository;

	
	@Transactional
	public void 글작성(Board board, User user) {
	
		board.setUser(user);
		
		boardRepository.save(board);
	}
	
	
	@Transactional
	public void 글삭제(int id) {
		
		boardRepository.deleteById(id);
		
	}


	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {

		return boardRepository.findAll(pageable);
	}


	public Board 상세보기(int id) {
		return  boardRepository.findById(id)
				.orElseThrow(()->{
			
			return new CustomApiException("목록 조회 실패");
		
		});
		
		
	}



	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

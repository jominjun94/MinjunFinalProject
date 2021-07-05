package com.cos.Mproject.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.Mproject.domain.board.Board;
import com.cos.Mproject.service.BoardService;
import com.cos.Mproject.service.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class BoardController {

	
	private final BoardService boardService; 
	
	//메인 페이지
	@GetMapping("/board")
	public String board(Model model, @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		 
		
		Page<Board> boards = boardService.글목록(pageable);
		
		model.addAttribute("boards",boards);
		
		
		return "board/board";
	}
	
	
	@GetMapping("/board/{id}")
	public String boardId(@PathVariable int id,Model model) {
		 
		
		Board board = boardService.상세보기(id);
			
		
		model.addAttribute("board",board);
		
		
		return "board/detail";
	}
	
	
	
	//작성 페이지
	
	@GetMapping("/board/write")
	public String boardWrites() {
		return "board/write";
	}
	
	
	

}

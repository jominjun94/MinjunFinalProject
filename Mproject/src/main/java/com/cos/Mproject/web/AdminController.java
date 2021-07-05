package com.cos.Mproject.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.board.Board;
import com.cos.Mproject.service.BoardService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class AdminController {
	private final BoardService boardService; 
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/info")
	public String adminInfo(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
		model.addAttribute("admin",details.getUser());
		
		return "admin/info";
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/board")
	public String adminBoard(Model model, @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Board> boards = boardService.글목록(pageable);
		
		model.addAttribute("boards",boards);
		
		return "admin/board";
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/board/{id}")
	public String admindetail(@PathVariable int id,Model model) {
		Board board = boardService.상세보기(id);
			
		
		model.addAttribute("board",board);
		
		
		return "admin/detail";
	}
	
	
	//@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
	//@GetMapping("/admin/AdMan")
	//public String adminManger(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
	//	model.addAttribute("admin",details.getUser());
		
	//	return "admin/info";
	//}
}

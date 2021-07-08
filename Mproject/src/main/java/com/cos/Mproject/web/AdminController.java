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
import com.cos.Mproject.domain.reply.Reply;
import com.cos.Mproject.service.BoardService;
import com.cos.Mproject.service.ReplyService;
import com.cos.Mproject.service.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class AdminController {
	private final BoardService boardService; 
	private final UserService userService;
	private final ReplyService replyService;
	
	// 메인 페이지
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin")
	public String adminInfo(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
		model.addAttribute("admin",details.getUser());
		
		return "admin/info";
	}
	
	//글목록
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/board")
	public String adminBoard(Model model, @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Board> boards = boardService.글목록(pageable);
		
		
		int pageNumber=boards.getPageable().getPageNumber(); //현재페이지
		int totalPages=boards.getTotalPages(); //총 페이지 수. 검색에따라 10개면 10개..
		int pageBlock = 5; //블럭의 수 1, 2, 3, 4, 5
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1; //현재 페이지가 7이라면 1*5+1=6
		int endBlockPage = startBlockPage+pageBlock-1; //6+5-1=10. 6,7,8,9,10해서 10
		endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;

	
		model.addAttribute("startBlockPage", startBlockPage); 
		model.addAttribute("endBlockPage", endBlockPage);

		
		model.addAttribute("boards",boards);
		
		return "admin/board";
	}
	
	//글상세보기
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/board/{id}")
	public String admindetail(@PathVariable int id,Model model) {
		Board board = boardService.상세보기(id);
			
	

		
		model.addAttribute("board",board);
		
		
		return "admin/detail";
	}
	
	
	//REPLY
		@Secured("ROLE_ADMIN")
		@GetMapping("/admin/reply/{id}")
		public String adminrely(@PathVariable String id,Model model) {
			
			userService.회원찾기(id);
			
			model.addAttribute("user",userService.회원찾기(id));
			
			return "admin/reply";
		}
	
	
		
		//Reply 글목록
		@Secured("ROLE_ADMIN")
		@GetMapping("/admin/board/boardReply")
		public String boardReply(Model model, @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
			
			Page<Reply> boards = replyService.글목록(pageable);
		
			
			int pageNumber=boards.getPageable().getPageNumber(); //현재페이지
			int totalPages=boards.getTotalPages(); //총 페이지 수. 검색에따라 10개면 10개..
			int pageBlock = 5; //블럭의 수 1, 2, 3, 4, 5
			int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1; //현재 페이지가 7이라면 1*5+1=6
			int endBlockPage = startBlockPage+pageBlock-1; //6+5-1=10. 6,7,8,9,10해서 10
			endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;

		
			model.addAttribute("startBlockPage", startBlockPage); 
			model.addAttribute("endBlockPage", endBlockPage);

			
			model.addAttribute("boards",boards);
			
			
			return "admin/boardReply";
		}
		
		
		
		//REPLY 글상세보기
		@Secured("ROLE_ADMIN")
		@GetMapping("/admin/board/reply/{id}")
		public String replydetail(@PathVariable int id,Model model) {
			Reply reply = replyService.상세보기(id);
				
			
			model.addAttribute("reply",reply);
			
			
			return "admin/replyDetail";
		}

		
	//@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
	//@GetMapping("/admin/AdMan")
	//public String adminManger(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
	//	model.addAttribute("admin",details.getUser());
		
	//	return "admin/info";
	//}
}

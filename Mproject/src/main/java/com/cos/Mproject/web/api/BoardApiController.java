package com.cos.Mproject.web.api;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.board.Board;
import com.cos.Mproject.handler.CMRespDTO;
import com.cos.Mproject.service.BoardService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class BoardApiController {

	
	private final BoardService boardService;
	
	//글쓰기
	@PostMapping("/api/board")
	public ResponseEntity<?> boardWrite(@RequestBody Board board,@AuthenticationPrincipal PrincipalDetails details){
		
		boardService.글작성(board,details.getUser());
		
		return new ResponseEntity<>(new CMRespDTO<>(1,"글 작성 성공",null), HttpStatus.OK);
	}
	

	
	@DeleteMapping("/api/board/{id}")
	public ResponseEntity<?> boardDelete(@PathVariable int id){
		
		boardService.글삭제(id);
		return new ResponseEntity<>(new CMRespDTO<>(1,"글 삭제 성공",null), HttpStatus.OK);
	}
	
}

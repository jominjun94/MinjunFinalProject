package com.cos.Mproject.web.api;



import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.board.Board;
import com.cos.Mproject.dto.board.BoardDto;
import com.cos.Mproject.handler.CMRespDTO;
import com.cos.Mproject.handler.CustomValidationApiException;
import com.cos.Mproject.service.BoardService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class BoardApiController {

	
	private final BoardService boardService;
	
	//글쓰기
	@PostMapping("/api/board")
	public ResponseEntity<?> boardWrite(@Valid @RequestBody BoardDto boardDto,BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails details){
		
		 
		/*/* aop 가 대신 하게 됩니다
		 * if(bindingResult.hasErrors()) { Map<String, String> errorMap = new
		 * HashMap<String, String>();
		 * 
		 * for(FieldError error : bindingResult.getFieldErrors()) {
		 * errorMap.put(error.getField(), error.getDefaultMessage()); }
		 * 
		 * 
		 * throw new CustomValidationApiException("유효성실패",errorMap); }
		 */
		
		
		boardService.글작성(boardDto.getContent(),boardDto.getTitle(),details.getUser());
		
		return new ResponseEntity<>(new CMRespDTO<>(1,"글 작성 성공",null), HttpStatus.OK);
	}
	

	
	@DeleteMapping("/api/board/{id}")
	public ResponseEntity<?> boardDelete(@PathVariable int id){
		
		boardService.글삭제(id);
		return new ResponseEntity<>(new CMRespDTO<>(1,"글 삭제 성공",null), HttpStatus.OK);
	}
	
}

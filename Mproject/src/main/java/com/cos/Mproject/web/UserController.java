package com.cos.Mproject.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.Mproject.config.auth.PrincipalDetails;
import com.cos.Mproject.domain.user.User;
import com.cos.Mproject.dto.user.UserDto;
import com.cos.Mproject.photo.Photo;
import com.cos.Mproject.service.ImageService;
import com.cos.Mproject.service.PhotoService;
import com.cos.Mproject.service.SubscribeService;
import com.cos.Mproject.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userserivce;
	private final SubscribeService subscribeService;
	private final PhotoService photoService;
	
	
	@GetMapping("/user/usersubview")
	public String usersubview() {
		
	
		return "user/usersubview";
		
	}
	
	
	@GetMapping("/user/update")
	public String profile() {
		return "auth/update";
	}	
	
	
	
	
	
	
	@GetMapping("user/{id}")
	public String profile(@PathVariable int id, Model model,@AuthenticationPrincipal PrincipalDetails details) {
		
		UserDto userEntity = userserivce.회원프로필(id,details.getUser().getId());
		
		List<Integer> subp =  subscribeService.구독자가져오기(details.getUser().getId());  
		
		Photo photoEntity = photoService.회원사진가져오기(id);
		
		List<User> users = new  ArrayList<User>();
		
		
		
		// 회원 정보를 가져와서 add 시킨 후 view 로 던짐 
		for(int i = 0; i < subp.size(); i ++) {
		    	subp.get(i); 
		    	System.out.println(subp.get(i));
		        User user = userserivce.구독회원(subp.get(i));
		      
		        users.add(user);
		    	
		}
		

		
		model.addAttribute("users",users);
		model.addAttribute("dto",userEntity);
		model.addAttribute("photo",photoEntity);
		return "user/view";
	}
	
	
	
	

}

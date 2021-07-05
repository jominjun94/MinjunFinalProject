package com.cos.Mproject.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.Mproject.config.auth.PrincipalDetails;

@Controller
public class AdminController {

	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/info")
	public String adminInfo(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
		model.addAttribute("admin",details.getUser());
		
		return "admin/info";
	}
	
	
	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
	@GetMapping("/admin/AdMan")
	public String adminManger(Model model ,@AuthenticationPrincipal PrincipalDetails details) {
		
		model.addAttribute("admin",details.getUser());
		
		return "admin/info";
	}
}

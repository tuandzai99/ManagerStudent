package com.tuanother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.tuanother.models.Admin;
import com.tuanother.services.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/login")
	public String login() {
		return "admin/dangnhap";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/";
	}

	@GetMapping("")
	public String home(){
		return "ds/menu";
	}

//	@PostMapping( "/home")
//	public String checkLogin(ModelMap model, @RequestParam("username") String username,
//			@RequestParam("password") String password) {
//		if (adminService.checkLogin(username, password)) {
//
//			return "redirect:/home";
//		} else {
//			model.addAttribute("ERROR", "Tên đăng nhập hoặc mật khẩu không đúng!!!");
//		}
//
//		return "admin/dang-nhap";
//
//	}

	@RequestMapping("/register")
	public String dangKy(ModelMap model) {

		model.addAttribute("admin", new Admin());
		return "admin/dang-ky-admin";
	}

	@RequestMapping("/save-user")
	public String saveAdmin(@ModelAttribute("admin") Admin admin, ModelMap model) {
		if(adminService.checkAccount(admin.getUsername(), admin.getPassword())) {
			model.addAttribute("ERROR","Tên tài khoản đã tồn tại!!!");
			return "admin/dang-ky-admin";
		} else {
			adminService.save(admin);
			return "redirect:/login";
		}

	}

	
	
}

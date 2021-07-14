package kr.co.ch05.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.UserService;
import kr.co.ch05.vo.UserVo;

@Controller
public class UserController {

	@Inject
	private UserService service;
	
	@GetMapping("/user/list")
	public String list() {
		return "/user/list";
	}

	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		
		service.insertUser(vo);
		
		return "/user/register";
	}
	
	@GetMapping("/user/modify")
	public String modify() {
		return "/user/modify";
	}
}

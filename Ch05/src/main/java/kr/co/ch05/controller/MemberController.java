package kr.co.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/list")
	public String list() {
		return "/member/list";
	}
	@RequestMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@RequestMapping("/member/modify")
	public String modify() {
		return "/member/modify";
	}
}

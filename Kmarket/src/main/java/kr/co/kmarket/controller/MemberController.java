package kr.co.kmarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}

	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		
		MemberVo memberVo = service.selectMember(uid, pass);
		
		if(memberVo != null) {
			sess.setAttribute("sessMember", memberVo);
			return "redirect:/";
		}else {
			return "redirect:/member/login?success=0";
		}
		
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@GetMapping("/member/signup")
	public String signup() {
		return "/member/signup";
	}
}

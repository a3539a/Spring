package kr.co.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.vo.UserVO;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/index"})
	public String index(Model model) {
		
		String title = "스프링 부트 타임리프 연습하기";
		String hello = "Hello Thymeleaf!!";
		
		UserVO user = new UserVO();
		user.setUid("a101");
		user.setName("홍길동");
		user.setHp("010-1234-5500");
		user.setPos("영업");
		user.setDep(101);
		user.getRdate();
		
		List<UserVO> users = new ArrayList<UserVO>();
		users.add(new UserVO("b101","김유신","010-4545-8787","영업1팀",101,"2012"));
		users.add(new UserVO("b102","김춘추","010-4545-8781","영업2팀",102,"2012"));
		users.add(new UserVO("b103","장보고","010-4545-8782","영업3팀",103,"2012"));
		users.add(new UserVO("b104","이순신","010-4545-8783","영업4팀",104,"2012"));
		users.add(new UserVO("b105","강감찬","010-4545-8784","영업5팀",105,"2012"));
		
		model.addAttribute("title", title);
		model.addAttribute("hello", hello);
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		
		return "/index";
	}
}

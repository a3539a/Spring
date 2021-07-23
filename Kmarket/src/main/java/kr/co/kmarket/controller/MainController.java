package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	// Model : jsp의 request처럼 정보를 받아서 Thymeleaf에 정보를 넘겨준다.(자동으로)
	@GetMapping(value = {"", "/index"})
	public String index(Model model) {
		
		List<ProductVo> productHit = service.selectHitProduct();
		List<ProductVo> productRecommand = service.selectRecommandProduct();
		
		model.addAttribute("productHit", productHit);
		model.addAttribute("productRecommand", productRecommand);	
		
		return "/index";
	}
	
	// @ResposBody : page를 불러오는게 아니라 데이터를 불러올 때
	@ResponseBody
	@GetMapping("/categories")
	public List<CategoriesVo> getCategories() {
		return service.selectCategories();
	}
	
	@ResponseBody
	@GetMapping("/getLatestProduct")
	public List<ProductVo> getLatestProduct() {
		
		return service.selectLatestProduct();
	}	
	
	@ResponseBody
	@GetMapping("/getDiscountProduct")
	public List<ProductVo> getDiscountProduct() {
		
		return service.selectDiscountProduct();
	}
}

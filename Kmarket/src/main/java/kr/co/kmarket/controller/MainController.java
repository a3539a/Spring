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
		model.addAttribute("productHit", productHit);
		
		List<ProductVo> productScore = service.selectScoreProduct();
		model.addAttribute("productScore", productScore);	
		
		List<ProductVo> productRdate = service.selectRdateProduct();
		model.addAttribute("productRdate", productRdate);
		
		List<ProductVo> productDiscount = service.selectDiscountProduct();
		model.addAttribute("productDiscount", productDiscount);
		
		return "/index";
	}
	
	// @ResposBody : page를 불러오는게 아니라 데이터를 불러올 때
	@ResponseBody
	@GetMapping("/categories")
	public List<CategoriesVo> getCategories() {
		return service.selectCategories();
	}
}

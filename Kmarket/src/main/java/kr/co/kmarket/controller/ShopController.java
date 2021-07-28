package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class ShopController {

	@Autowired
	private ShopService service;
	
	@ResponseBody
	@PostMapping("/shop/deleteCart")
	public String deleteCart(HttpSession sess, int[] codes) {
		
		MemberVo memberVo = (MemberVo) sess.getAttribute("sessMember");
		String uid = memberVo.getUid();
		
		for(int code : codes) {
			service.deleteCart(uid, code);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", codes.length);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/shop/cart")
	public String cart(HttpSession sess, Model model) {
		
		// 세션에 사용자 정보 확인
		MemberVo memberVo = (MemberVo)sess.getAttribute("sessMember");
		
		if(memberVo != null) {
			// 로그인 되 있으면
			String uid = memberVo.getUid();
			
			List<CartVo> products = service.selectCart(uid);
			model.addAttribute("products", products);
			
			return "/shop/cart";
		}else {
			// 로그인이 안 됐으면
			return "redirect:/member/login?success=103";
		}
		
		
	}		
	
	@ResponseBody
	@PostMapping("/shop/cart")
	public String cart(CartVo vo, HttpSession sess) {
		
		// 세션에 사용자 정보
		MemberVo memberVo = (MemberVo) sess.getAttribute("sessMember");
		
		int result = 0;
		
		if(memberVo != null) {
			// 로그인 했을 경우
			
			String uid = memberVo.getUid();
			int code = vo.getCode();
			
			vo.setUid(memberVo.getUid());
			
			// 장바구니에 상품이 있으면 카운트
			int count = service.selectCountCart(code, uid);
			
			if(count < 1) {
				// 장바구니에 상품이 없으면
				service.insertCart(vo);
				result = 1;
			}else {
				// 이미 상품이 장바구니에 있을 경우
				result = 3;
			}
		}else {
			// 로그인 안 했을 경우
			result = 2;
		}
		// json data로 변환
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}	
	
	@GetMapping("/shop/list")
	public String list(Model model, int cate1, int cate2, String sort) {
		
		ProductVo titles = service.selectTitles(cate1, cate2);
		List<ProductVo> products = service.selectProducts(cate1, cate2, sort);
		
		model.addAttribute("titles", titles);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("products", products);
		
		return "/shop/list";
	}	
	
	@GetMapping("/shop/order")
	public String order() {
		return "/shop/order";
	}	
	
	@ResponseBody
	@PostMapping("/shop/order")
	public String order(OrderVo vo) {
		
		service.insertOrder(vo);
		
		// 최근 insert한 데이터 orderId
		int orderId = vo.getOrderId();
		
		for(int code : vo.getCodes()) {
			service.insertOrderDetail(orderId, code);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("orderId", orderId);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete() {
		return "/shop/order-complete";
	}	
	
	@GetMapping("/shop/search")
	public String search() {
		return "/shop/search";
	}	
	
	@GetMapping("/shop/view")
	public String view(int code, Model model) {
		
		ProductVo product = service.selectProduct(code);
		
		model.addAttribute("product", product);
		
		return "/shop/view";
	}
}

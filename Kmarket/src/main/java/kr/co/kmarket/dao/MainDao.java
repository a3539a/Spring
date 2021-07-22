package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface MainDao {

	public List<CategoriesVo> selectCategories();
	
	public List<ProductVo> selectHitProduct();
	
	public List<ProductVo> selectScoreProduct();
	
	public List<ProductVo> selectRdateProduct();
	
	public List<ProductVo> selectDiscountProduct();
	
}

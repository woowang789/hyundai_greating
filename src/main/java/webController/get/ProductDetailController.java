package webController.get;

import java.util.Map;

import dao.ProductDAO;
import vo.ProductDetailVO;
import webController.WebControllerInter;

public class ProductDetailController implements WebControllerInter{
	private ProductDAO productDao = ProductDAO.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		ProductDetailVO vo = productDao.getProductDetail(paramMap.get("prodId"));
		return "product_detail";
	}
	

}

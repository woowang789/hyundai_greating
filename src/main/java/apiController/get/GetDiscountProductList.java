package apiController.get;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;
import dao.ProductDAO;
import vo.ProductVO;

public class GetDiscountProductList implements ApiControllerInter{
	private ProductDAO dao = ProductDAO.getInstance();
	
	@Override
	public void process(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		String discntId = paramMap.get("discntId");
		if(discntId == null) discntId= "50";
		List<ProductVO> list = dao.getProductListByDiscnt(discntId);
		model.put("list", list);
		model.put("count", list.size());
	}

}

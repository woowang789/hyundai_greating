package apiController.get;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import apiController.ApiAction;
import dao.ProductDAO;
import vo.ProductVO;

/**
 * 
 * @author 왕종휘
 */
public class GetBestProductList implements ApiAction{
	private ProductDAO dao = ProductDAO.getInstance();

	@Override
	public void execute(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		String cateId = paramMap.get("cateId");
		if(cateId == null) cateId= "50";
		List<ProductVO> list = dao.getProductListByOrderQty(cateId);
		model.put("list", list);
		model.put("count", list.size());
		
	}
	

}

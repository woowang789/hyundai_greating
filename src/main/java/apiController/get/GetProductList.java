package apiController.get;

import java.util.List;
import java.util.Map;

import apiController.ApiAction;
import dao.ProductDAO;
import vo.ProductVO;

public class GetProductList implements ApiAction{
	private ProductDAO dao = ProductDAO.getInstance();

	@Override
	public void process(String body,Map<String,String> paramMap,Map<String, Object> model) {
		String cateId = paramMap.get("cateId");
		if(cateId == null) cateId= "50";
		List<ProductVO> list = dao.getProductList(cateId);
		model.put("list", list);
		model.put("count", list.size());
	}
}

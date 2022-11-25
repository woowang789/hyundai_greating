package apiController.get;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import apiController.ApiControllerInter;
import dao.ProductDAO;
import dao.TestDao;
import vo.ProductVO;

public class GetProductList implements ApiControllerInter{
	private ProductDAO dao = ProductDAO.getInstance();
	private TestDao test = TestDao.getInstance();
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void process(String body,Map<String,String> paramMap,Map<String, Object> model) {
		String cateId = paramMap.get("cateId");
		if(cateId == null) throw new RuntimeException("파라미터 없음");
		List<ProductVO> list = dao.getProductList(cateId);
		model.put("list", list);
		model.put("count", list.size());
	}
}

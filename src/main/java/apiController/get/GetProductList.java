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
import vo.ProductVO;

public class GetProductList implements ApiControllerInter{
	private ProductDAO dao = ProductDAO.getInstance();
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void process(String body,Map<String, Object> model) {
		List<ProductVO> list = dao.getProdictList();
		model.put("list", list);
		model.put("count", list.size());
	}
}

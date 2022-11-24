package dao;

import java.util.ArrayList;
import java.util.List;

import vo.ProductVO;

final public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> getProdictList(){
		// 여기에 DB 연결해서 끌어와야 함
		List<ProductVO> list = new ArrayList<>();
		
		ProductVO p = new ProductVO();
		p.setId(123361);
		p.setThumbImgUrl("https://image.greating.co.kr/IL/item/202203/10/C_4600DC6363644EF3BD9321FA7704098C.jpg");
		p.setName("소고기야채죽(1인분)");
		p.setSubName("간편하게 즐기는");
		p.setStorage("냉동");
		p.setOriginPrice(5500);
		p.setStock(30);
		p.setMarketPrice(5000);
		p.setDiscountRate(10);
		
		ProductVO p1 = new ProductVO();
		p1.setId(132577);
		p1.setThumbImgUrl("https://image.greating.co.kr/IL/item/202210/14/C_020BA851F83F428BA1EE20A48B50ADB6.jpg");
		p1.setName("코다리조림 밀키트");
		p1.setSubName("쫄깃한 코다리살이 일품인");
		p1.setStorage("냉동");
		p1.setOriginPrice(11800);
		p1.setStock(30);
		p1.setMarketPrice(11800);
		p1.setDiscountRate(10000);
		
		ProductVO p2 = new ProductVO();
		p2.setId(100835);
		p2.setThumbImgUrl("https://image.greating.co.kr/IL/item/202107/10/C_C4B16799A1184A4099E951AB5523C189.jpg");
		p2.setName("연잎 오겹수육 (2인분)");
		p2.setSubName("국산 오겹살로 만든");
		p2.setStorage("냉장");
		p2.setOriginPrice(18000);
		p2.setStock(5);
		p2.setMarketPrice(18000);
		p2.setDiscountRate(16200);
		
		list.add(p);
		list.add(p1);
		list.add(p2);
		return list;
	}
	
	
	
}

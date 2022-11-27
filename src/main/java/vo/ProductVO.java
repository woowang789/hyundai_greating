package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductVO {

	private int id;
	
	private String thumbImgUrl;
	
	private String name;
	private String subName;
	private String storage;
	private int originPrice;
	private int marketPrice;
	private int discountRate;
	
	private int stock;
	private String grts;
	
	
}

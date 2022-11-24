package vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWithGrtVO {
	private int id;
	private String thumbImgUrl;
	private String name;
	private String subName;
	private String storage;
	private int originPrice;
	
	private int stock;
	private int marketPrice;
	private int discountRate;
	
	private String grt;
	
}

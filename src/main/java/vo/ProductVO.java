package vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 소규석
 */ 

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
	
	private String prodImgUrl;
	
	private int stock;
	private String grts;
	
	public void setProdImgUrl(String url) {
		this.prodImgUrl = "http://localhost/image" + url;
	}
	
	public void setThumbImgUrl (String thumbUrl) {
		this.thumbImgUrl = "http://localhost/image"+thumbUrl;
	}
}

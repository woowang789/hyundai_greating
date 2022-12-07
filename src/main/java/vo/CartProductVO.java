package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartProductVO {
	private String prodId;
	private String prodName;
	private String prodOptnId;
	private String prodOptnName;
	private String thumbUrl;
	private int originPrice;
	private int marketPrice;
	private int discntRate;
	private int qty;
	private int stock;
	
	public void setThumbUrl(String url) {
		this.thumbUrl = "http://localhost/image" +url;
	}
}

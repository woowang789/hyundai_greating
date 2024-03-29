package vo;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 이세아
 */

@Getter @Setter
public class OrderProductVO {
	private String userid;
	
	private Date orderDate;
	private long orderDateLong;
	private String prodName;
	private String thumbImgUrl;
	private String optName;
	
	private int marketPrice;
	private int originPrice;
	private int discountAmount;
	
	private int prodId;
	private int optnId;
	
	private int qty;
	
	private CommentVO comment;
	
	public void setThumbImgUrl(String url) {
		this.thumbImgUrl = "http://localhost/image" + url;
	}
}

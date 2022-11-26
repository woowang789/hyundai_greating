package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderlistVO {
	
	private String userid;
	
	private String ordertime;
	private String prodname;
	private String thumbImgUrl;
	private String prodoptName;
	private int originPrice;
	private int orderquantity;
	
}

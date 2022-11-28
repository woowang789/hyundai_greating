package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProductBeforeVO {
	private int prodId;
	private int optnId;
	private String thumbUrl;
	private String type;
	private String prodName;
	private String optnName;
	private int stock;
	private int discountRate;
	private int originPrice;
	private int marketPrice;
}

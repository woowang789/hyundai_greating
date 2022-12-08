package vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 이세아
 */

@Getter @Setter
public class OrderProductInsertVO {
	private int optnId;
	private int qty;
	private int price;
	private int prodId;
}

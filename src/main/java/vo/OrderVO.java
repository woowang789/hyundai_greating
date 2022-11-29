package vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OrderVO {
	
	private List<OrderProductVO> orderProds = new ArrayList<>();
	private Date orderDate;
	private long orderDateLong;
	private int totalOriginPrice;
	private int totalDiscountAmount;
	private int totalMarketPrice;
	private String status;
	
	private String receiverName;
	private String receiverAddr;
	private String receiverTel;

}

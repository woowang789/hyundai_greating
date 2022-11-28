package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OrderReviewInsertVO {
	
	private List<OrderReviewInsertVO> orderReviews = new ArrayList<>();
	private String commentTitle;
	private String commentText;
	private Date orderReviewDate;
	private int prodOpId;
	private int prodId;
	private String userId;
	private Date orderDate;


	
}
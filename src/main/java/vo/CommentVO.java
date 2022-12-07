package vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentVO {
	private int prodId;
	private int optnId;
	private String optnName;
	private Date orderDate;
	
	private String userId;
	private String userIdWithMask;
	
	private String title;
	private String text;
	private Date commentDate;
	
}

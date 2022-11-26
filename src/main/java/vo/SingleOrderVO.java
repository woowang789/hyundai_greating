package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SingleOrderVO {
	
	private String userid;
	
	private String prodname;
	private String prodoptname;
	private String prodthnlimgurl;
	private int quantity;
	private int prodprice;
	private int marketprice;
	private int discntprice;
	private int totalprodprice;
	private int totaldiscntprice;
	private int totalcusprice;
	
	private String status;
	private String recipient;
	private String rctel;
	private String rcadd;
	
	

}

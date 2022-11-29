package vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDetailVO {
	private ProductVO prod;
	private SellerVO seller;
	private List<IgdtVO> igdtList = new ArrayList<>();
	private List<GrtVO> grtList = new ArrayList<>();
	private List<ProductOptionVO> optnList = new ArrayList<>();
	
	private int cal;
	private int vol;
	private String origin;
	
	private String text;
	private String imgUrl;
	private String pkgUrl;
	private String type;
	private List<String> contextUrls = new ArrayList<>();
	
	
}

package vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDetailVO {

	private int id;
	
	private String prodImgUrl;
	private String pkgUrl;
	private List<String> contentUrls = new ArrayList<>();
	
	private String name;
	private String subName;
	private String storage;
	private int originPrice;
	private int marketPrice;
	private int discountRate;
	
	private int volumn;
	private int calory;
	private String text;
	
	
	private List<ProductOptionVO> options = new ArrayList<>();
	
	
	
	
}

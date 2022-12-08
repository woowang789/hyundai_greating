package vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author 촤태승
 */ 

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
	private String nutriImgUrl;
	
	private List<String> contextUrls = new ArrayList<>();
	
	public void setNutriImgUrl(String url) {
		this.nutriImgUrl = "http://localhost/image" + url;
	}
	
	public void setImgUrl(String url) {
		this.imgUrl = "http://localhost/image" + url;
	}
	
	public void setPkgUrl (String url) {
		this.pkgUrl = "http://localhost/image"+url;
	}
	public void setcontextUrls(String urls) {
		String[] urlArr = urls.split(",");
		for(String url : urlArr) 
			this.contextUrls.add("http://localhost/image"+url);
		
	}
	
	
}

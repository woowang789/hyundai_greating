package vo;

import org.json.simple.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
	private int id;
	private String thumbImgUrl;
	private String name;
	private String subName;
	private String storage;
	private int originPrice;
	
	private int stock;
	private int marketPrice;
	private int discountRate;
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("thumbImgUrl", thumbImgUrl);
		obj.put("name", name);
		obj.put("subName", subName);
		obj.put("storage", storage);
		obj.put("originPrice", originPrice);
		obj.put("stock", stock);
		obj.put("marketPrice", marketPrice);
		obj.put("discountRate", discountRate);
		return obj;
	}
}

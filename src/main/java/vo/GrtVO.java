package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GrtVO {
	private int id;
	private String iconurl="";
	private String name;
	
	public void setIconurl(String url) {
		this.iconurl = "http://localhost/image" +url;
	}
}

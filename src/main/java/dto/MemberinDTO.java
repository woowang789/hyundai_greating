package dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberinDTO {
	
	private String id;
	private String name;
	private String email;
	private Date birth;
	private String sex;
	private String password;

}

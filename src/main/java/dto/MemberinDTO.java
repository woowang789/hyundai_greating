package dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 이세아
 */

@Getter @Setter
public class MemberinDTO {
	
	private String id;
	private String name;
	private String email;
	private Date birth;
	private String sex;
	private String password;

}

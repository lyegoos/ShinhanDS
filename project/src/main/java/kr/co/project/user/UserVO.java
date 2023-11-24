package kr.co.project.user;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserVO {
	private int no;
	private String email;
	private String pwd;
	private String name;
	private int gender;
	private String birthday;
	private String hp;
	private Timestamp registdate;
	private String zipcode;
	private String addr1;
	private String addr2;
	
}

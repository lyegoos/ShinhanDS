package chapter12;

import lombok.Data;

@Data
public class MemberVO {
	private int no;
	private String id;
	private String name;
	private String filename_org;
	private String filename_real;
	private String password;
	
	private String[] hobbyname;		// 이건 왜 넣느냐. HobbyVO에 있지만,, Service의 insert 메서드를 보면 배열로 넘어올 것이기 때문에 추가해줌
}

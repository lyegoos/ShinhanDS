package kr.co.project.user;

public interface UserService {
	boolean dupEmail(String email);
	boolean regist(UserVO vo);
	UserVO login(UserVO vo);
	UserVO detail(UserVO vo);
	int update(UserVO vo);
}

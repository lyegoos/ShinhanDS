package kr.co.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public boolean dupEmail(String email) {
		// TODO Auto-generated method stub
		return mapper.dupEmail(email) > 0 ? true : false;	// 중복이 있으면 true 
	}

	@Override
	public boolean regist(UserVO vo) {
		// TODO Auto-generated method stub
		return mapper.regist(vo) > 0 ? true : false;
	}

	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return mapper.login(vo);
	}

	@Override
	public UserVO detail(UserVO vo) {
		// TODO Auto-generated method stub
		return mapper.detail(vo.getNo());
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}
	
	
}

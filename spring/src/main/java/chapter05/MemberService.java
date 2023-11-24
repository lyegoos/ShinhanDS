package chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public MemberVO getMember(MemberVO vo) {
		return dao.getMember(vo);
	}

}

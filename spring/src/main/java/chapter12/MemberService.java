package chapter12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)	//예외가 발생하면 롤백
	public boolean insert(MemberVO mvo) {		// 매퍼에 있는 sql을 수행하고 정상적으로 수행됐다면 true 아니면 false를 수행해야지! 이므로 리턴값은 boolean인 것, mvo에는 사용자가 입력한 값이 들어있을 것
		System.out.println("등록전 no:" + mvo.getNo());
		int r = mapper.insertMember(mvo);		// 이렇게 하면 회원이 등록된다.
		System.out.println("등록후 no:" + mvo.getNo());
		//취미 등록
		if ( r > 0 /*회원이 정상적으로 등록된 경우에만 하비를 등록하겠다*/) {
			HobbyVO hvo = new HobbyVO();
			hvo.setMember_no(mvo.getNo());
			//반복
			for(String hobbyname : mvo.getHobbyname()) {
				hvo.setHobbyname(hobbyname);	
				mapper.insertHobby(hvo);
			}
		}
		//취미명(배열 - 사용자로부터 배열이 옴) 개수만큼 반복시켜야함, ★회원PK도 가져와서 저장★
		return true;
	}
	
	public List<MemberVO> listall() {
		return mapper.listall();
	}
	
	public MemberVO login(MemberVO vo) {
		return mapper.login(vo);
	}
	
	
	
}

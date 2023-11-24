package chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDAO memberDAO() {		// 여기의 memberDAO()와,
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl m = new MemberServiceImpl();
//		m.setMemberDAO(memberDAO());			// 여기의 memberDAO()는 같은 객체다.
		return m;
	}
	
	@Bean
	public MemberService memberService2() {
		return new MemberServiceImpl(memberDAO());
	}
}
package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl m = new MemberServiceImpl();
//		m.setMemberDAO(memberDAO());
		return m;
	}
	
	@Bean
	public MemberService memberService2() {
		return new MemberServiceImpl(memberDAO());
	}
	
	@Bean
	public MemberDAO adminDAO() {
		return new AdminDAOImpl();
	}
}
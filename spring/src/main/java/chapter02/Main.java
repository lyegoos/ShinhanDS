package chapter02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter02/member.xml");
		MemberService service = ctx.getBean("memberService", MemberServiceImpl.class);
		service.listMembers();
		
		MemberService service2 = ctx.getBean("memberService2", MemberServiceImpl.class);
		service.listMembers();
	}

}

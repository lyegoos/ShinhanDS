package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// xml대신 쓰는 자바 설정파일은 반드시 @Configuration 입력
public class AppCtx {
	@Bean
	public PersonService personService() {	//메서드명이 ID
		PersonServiceImpl ps = new PersonServiceImpl();		
		ps.setName("홍길동");
		return ps;
	}
	
	@Bean
	public PersonService personService1() {	//메서드명이 ID
		PersonServiceImpl ps = new PersonServiceImpl("이순신");		
		return ps;
	}
	
	@Bean
	public PersonService personService2() {	//메서드명이 ID
		PersonServiceImpl ps = new PersonServiceImpl("손흥민", 23);		
		ps.setName("홍길동");
		return ps;
	}
}

package kr.co.project.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {kr.co.project.config.MvcConfig.class})
@WebAppConfiguration
public class UserMapperTest {
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void regist() {
		UserVO vo = new UserVO();
		vo.setEmail("hong@gmail.com");
		vo.setPwd("hong1234");
		vo.setName("홍길동");
		vo.setGender(0);	//여성
		vo.setBirthday("2023-11-20");
		vo.setHp("010-1234-5678");
		
		mapper.regist(vo);
	}
	
	@Test
	public void dupEmail() {
		int r = mapper.dupEmail("hong@gmail.com");
		System.out.println(r);
		if(r>0) System.out.println("중복");
		else System.out.println("사용가능");
	}
	
	@Test
	public void login() {
		UserVO vo = new UserVO();
		vo.setEmail("hong@gmail.com");
		vo.setPwd("hong1234");		// 비밀번호가 틀리면 null이 리턴
		System.out.println(mapper.login(vo));
	}
}

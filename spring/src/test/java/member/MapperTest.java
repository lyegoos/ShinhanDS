package member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chapter09.HobbyVO;
import chapter09.MemberMapper;
import chapter09.MemberService;
import chapter09.MemberVO;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {chapter09.MvcConfig.class})
@WebAppConfiguration
@Slf4j
public class MapperTest {
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void insertMember() {
		MemberVO vo = new MemberVO();
		vo.setId("aaa");
		vo.setName("AAA");
		mapper.insertMember(vo);
	}
	@Test
	public void insertHobby() {
		HobbyVO vo = new HobbyVO();
		vo.setMember_no(1);
		vo.setHobbyname("게임");
		mapper.insertHobby(vo);
	}
	
	@Autowired
	MemberService service;
	
	@Test
	public void serviceTest() {
		MemberVO vo = new MemberVO();
		vo.setId("cccc");
		vo.setName("CCCC");
		vo.setHobbyname(new String[]{"독서","영화","수영"});
		service.insert(vo);
	}
	
	
}

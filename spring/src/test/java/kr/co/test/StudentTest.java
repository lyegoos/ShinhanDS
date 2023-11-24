package kr.co.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import chapter08.StudentMapper;
import chapter08.StudentService;
import chapter08.StudentVO;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {chapter08.MvcConfig.class})
@WebAppConfiguration
@Slf4j
public class StudentTest {
	@Autowired
	StudentMapper mapper;
	
	@Test
	public void countTest() {
		System.out.println(mapper.count(new StudentVO()));
	}
	@Test
	public void listTest() {
		StudentVO vo = new StudentVO();
		vo.setSearchType("name");
		vo.setSearchWord("훈");
		System.out.println(mapper.search2(vo));
	}
	
	
	
	@Autowired
	StudentService service;
	
	@Test
	public void search2Test() {
		StudentVO vo = new StudentVO();
		vo.setSearchType("name");
		vo.setSearchWord("훈");
		log.info(service.search2(vo).toString());
	}
	
	//Controller 테스트
	@Autowired
	WebApplicationContext ctx;
	
	MockMvc mock;	//	메서드 앞에서 먼저 실행이 되야함
	
	@Before
	public void before() {
		mock = MockMvcBuilders.webAppContextSetup(ctx).build();		// MockMvc객체는 직접 못 만들고 빌더 객체를 통해서ㅂ	}
	}
	
	@Test
	public void index3() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/student/index3.do");
		mock.perform(req);
	}

	// 파라미터가 있는 경우(페이지, 검색어...)
	@Test
	public void index32() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/student/index3.do")
							.param("searchType","name").param("searchWord", "훈");
		mock.perform(req);
	}
}

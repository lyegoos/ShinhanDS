package kr.co.project.reply;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {kr.co.project.config.MvcConfig.class})
@WebAppConfiguration
public class ReplyMapperTest {
	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void list() {
		ReplyVO vo = new ReplyVO();
		// 검색
		vo.setSearchType("title");
		vo.setSearchWord("자바");
		int count = mapper.count(vo);
		List list = mapper.list(vo);
	}
	
	@Test
	public void insert() {
		for (int i=1; i<=101; i++) {
			ReplyVO vo = new ReplyVO();
			vo.setTitle("제목"+i);
			vo.setContent("내용"+i);
			mapper.insert(vo);
			mapper.updateGno(vo.getNo());
		}
	}
	
	
	
	
	
	
	
	
}

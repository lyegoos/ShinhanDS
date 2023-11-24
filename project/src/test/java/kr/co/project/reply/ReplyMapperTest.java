package kr.co.project.reply;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReplyMapperTest {

	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void list() {
		ReplyVO vo = new ReplyVO();
		
		vo.setSearchType("title");
		vo.setSearchWord("자바");
		int count = mapper.count(vo);
		List list = mapper.list(vo);
		
	}
	
	
	@Test
	public void insert() {
		for(int i=1; i<=10; i++) {
			ReplyVO vo = new ReplyVO();
			vo.setTitle("제목"+i);
			vo.setContent("내용"+i);
			mapper.insert(vo);
			mapper.updateGno(vo.getNo());
		}
	}
	
}

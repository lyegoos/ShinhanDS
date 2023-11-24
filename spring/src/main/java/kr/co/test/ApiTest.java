package kr.co.test;

import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import chapter09.MemberVO;

public class ApiTest {

	@Test
	public void test() throws JsonProcessingException {
		//Object -> json(text)
		
		MemberVO vo = new MemberVO();
		vo.setName("홍길동");
		vo.setId("hong");
		
		var list = new ArrayList<MemberVO>();
		list.add(vo);
		vo = new MemberVO();
		vo.setName("김길동");
		vo.setId("kim");
		list.add(vo);
		
		
		ObjectMapper om = new ObjectMapper();
		String text = om.writeValueAsString(vo);
		System.out.println(text);
		
		//json(text) -> Object(list)
		var obj = om.readValue(text, new TypeReference<ArrayList<MemberVO>>(){});
		System.out.println(obj);
	}
}

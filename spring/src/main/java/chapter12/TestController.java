package chapter12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("testtestController")
public class TestController {
	// 일반컨트롤러인데, 하나만 API로 리턴
	
	@ResponseBody // api처럼 리턴하고싶은거 위에 리스폰스바디
	@GetMapping("/test/test")
	public MemberVO test() {
		MemberVO vo = new MemberVO();
		vo.setName("홍길동");
		vo.setId("hong");
		return vo;
	}
}

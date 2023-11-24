package chapter12;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://127.0.0.1:5500") // 특정대상의 요청 허가
@CrossOrigin(origins="*") // 모든 요청 허가
@RestController //안에 있는 모든 메서드가 @ResponseBody 들어있는 것과 같음
@RequestMapping("/api")
public class MemberController {

	@GetMapping("/test")
	public MemberVO test() {
		MemberVO vo = new MemberVO();
		vo.setName("홍길동");
		vo.setId("hong");
		return vo;
	}
	@GetMapping("/test2")
	public ArrayList<MemberVO> test2() {
		MemberVO vo = new MemberVO();
		vo.setName("홍길동");
		vo.setId("hong");
		var list = new ArrayList<MemberVO>();
		list.add(vo);
		vo = new MemberVO();
		vo.setName("김길동");
		vo.setId("kim");
		list.add(vo);
		return list;
	}
	@Autowired
	private MemberMapper mapper;
	@GetMapping("/member/all")
	public List<MemberVO> all() {
		return mapper.listall();
	}
	@GetMapping("/member/detail")
	public MemberVO detail(@RequestParam int no) {
		return mapper.view(no);
	}
	
	@PutMapping("/member/regist")
	public MemberVO regist(@RequestBody MemberVO vo) {
		System.out.println(vo);
		return vo;
	}
	
	
	
}









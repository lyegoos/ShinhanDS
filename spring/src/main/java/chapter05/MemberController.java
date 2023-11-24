package chapter05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value={"/index.do","/index4.do"}, method=RequestMethod.GET)	// 매핑될 url  	// 이렇게 요청이 들어오면 매핑된 메서드가 실행된다.
	public String index() {
		System.out.println("index");
		return "member/index";	// JSP 경로를 쓰면 된다. prefix : /WEB-INF/views/, suffix : .jsp		/WEB-INF/views/?????.jsp -> ???에 들어갈 값을 리턴하면 된다.
	}
	@RequestMapping("/index2.do")	
	public String index2() {
		System.out.println("index2");
		return "member/index2";	
	}
	@GetMapping("/index3.do")	
	public String index3() {
		return "redirect:index.do";	//index3.do로 가면 index.do로 리다이렉트가 일어남
	}
	
	//void인 경우
	//요청 URL이랑 JSP 경로 동일하게 forward
	@GetMapping("/test.do")	// /member/test.do
	public void test() {
		//forward는 /WEB-INF/views/member.test.jsp
	}
	
	/*
	 * 파라미터를 받는 방법
	 * 
	 */
	
	//1. HttpServletRequest 객체 사용하는 첫번째 방법
	@GetMapping("/param1.do")
	public String param1(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println(id);
		return "member/test";
	}
	
	//2. @RequestParam
	@GetMapping("/param2.do")
	public String param2(@RequestParam(value="name", required = false, defaultValue="000") String id) {
		System.out.println(id);
		return "/member/test";
	}
	@GetMapping("/param2_1.do")
	public String param2_1(@RequestParam String id,
							@RequestParam String name,
							HttpServletRequest req,
							/*@ModelAttribute("vo")*/ MemberVO vo) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		System.out.println(vo);
		req.setAttribute("msg", "안녕하세요");
		return "/member/test";
	}
	
	//3. 커맨드 객체
	@GetMapping("/param3.do")
	public String param3 (MemberVO vo) {
		System.out.println(vo);
		return "member/test";
	}
	
	// 4. @PathVariable
	@GetMapping("/view/{id}")
	public String param4(@PathVariable String id) {
		System.out.println(id);
		return "member/index";
	}

	// 값 저장
	@GetMapping("/set.do")
	public ModelAndView set(Model model, MemberVO vo, HttpServletRequest req, HttpSession sess) {
		MemberVO mvo = service.getMember(vo);
		req.setAttribute("mvo", mvo);	//request
//		HttpSession sess = req.getSession();
		sess.setAttribute("svo", mvo);	//session
		model.addAttribute("modelvo", mvo);	//model
		ModelAndView mav = new ModelAndView();
		mav.addObject(mav);
		return mav;
	}
	
	
}

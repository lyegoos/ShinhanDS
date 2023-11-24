package chapter11;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/regist.do")
	public String regist() {
		return "member/write";
	}
	
	@PostMapping("/member/regist.do")
	public void /*String*/ insert(MemberVO vo, @RequestParam MultipartFile filename, HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(!filename.isEmpty()) {
			//파일명
			String org = filename.getOriginalFilename();
			String ext = org.substring(org.lastIndexOf("."));		// 확장자 ( .이 있는 위치부터이므로 .이 포함됨 )
			String real = "notice_" + System.currentTimeMillis() + ext;
			System.out.println(org);
			System.out.println(real);
			// 파일 저장
			String path = request.getRealPath("/upload/")+real;
			try {
				filename.transferTo(new File(path));	
			} catch (Exception e) {}
			vo.setFilename_org(org);
			vo.setFilename_real(real);
			
		}
		service.insert(vo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script>");
		writer.print("alert('정상적으로 등록되었습니다.');");
		writer.print("location.href='regist.do';");
		writer.print("</script>");
		
//		return "redirect:regist.do";	
	}
	
	
	@GetMapping("/member/index.do")
	public String index(Model model){
		model.addAttribute("selectallList", service.listall());
		return "member/list";
	}
	
	@GetMapping("/member/login.do")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login.do")
	public String loginProcess(MemberVO vo, HttpSession sess, HttpServletResponse response) throws ServletException, IOException{
		MemberVO login = service.login(vo);	// login 객체에 회원정보 담음, 회원정보 조회(vo에 담긴 아이디,비밀번호로)
		if(login != null) {	// login이 널이 아니다 == 로그인 성공시
			sess.setAttribute("loginSess", login);	// 세션에 회원정보를 저장
			return "redirect:index.do";
		} else	{	// 로그인 실패
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('아이디/비밀번호가 올바르지 않습니다.');");
			out.print("hisroty.back();");
			out.print("</script>");
			out.close();
			return null;
		}
	}
	
}

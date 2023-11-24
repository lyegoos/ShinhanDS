package chapter10;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String index(Model model) {
		model.addAttribute("selectallList", service.listall());
		return "member/list";
	}
	
}

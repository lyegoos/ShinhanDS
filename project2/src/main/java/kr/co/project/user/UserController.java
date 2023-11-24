package kr.co.project.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	
	@ResponseBody
	@GetMapping("/user/emailCheck.do")
	public String emailCheck(@RequestParam String email) {
		boolean r = service.dupEmail(email);
		return String.valueOf(r);
	}
	
	@PostMapping("/user/regist.do")
	public String regist(UserVO vo, Model model) {
		boolean r = service.regist(vo); // service -> mapper -> sql
		if (r) { // 정상적으로 DB에 insert 
			model.addAttribute("cmd", "move");
			model.addAttribute("msg", "회원가입되었습니다.");
			model.addAttribute("url", "/project/index.do");
		} else { // 등록안됨
			model.addAttribute("cmd", "back");
			model.addAttribute("msg", "회원가입실패");
		}
		return "common/alert";
	}
	
	@GetMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/user/login.do")
	public String loginProcess(UserVO vo, HttpSession sess, Model model) {
		UserVO login = service.login(vo);
		if (login == null) { // 로그인실패
			model.addAttribute("msg", "아이디 비밀번호가 올바르지 않습니다.");
			model.addAttribute("cmd", "back");
			return "common/alert";
		} else { // 로그인성공
			sess.setAttribute("loginInfo", login);
			return "redirect:/index.do";
		}
	}
	
	@GetMapping("/user/logout.do")
	public String logout(Model model, HttpSession sess) {
//		sess.removeAttribute("loginInfo");
		sess.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/project/index.do");
		model.addAttribute("cmd", "move");
		return "common/alert";
	}
	
	@GetMapping("/user/edit.do")
	public String edit(HttpSession sess, Model model) {
		UserVO uv = (UserVO)sess.getAttribute("loginInfo");
		model.addAttribute("vo", service.detail(uv));
		return "user/edit";
	}
	
	@PostMapping("/user/update.do")
	public String update(UserVO vo, Model model) {
		int r = service.update(vo);
		String msg = "";
		String url = "edit.do";
		if (r > 0) {
			msg = "정상적으로 수정되었습니다.";
		} else {
			msg = "수정 오류";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		model.addAttribute("cmd","move");
		return "common/alert";
	}
	
	
	
}

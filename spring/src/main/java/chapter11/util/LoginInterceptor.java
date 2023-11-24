package chapter11.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import chapter11.MemberVO;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession sess = request.getSession();
		MemberVO login = (MemberVO)sess.getAttribute("loginSess");
		if(login == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 후 사용가능합니다');");
			out.print("location.href='/test/member/login.do';");
			out.print("</script>");
			out.close();
			
			return false;	// 로그인 실패시 넌못지나간다
		}
		return true;	// 로그인 성공하면 가던길가라
	}
}

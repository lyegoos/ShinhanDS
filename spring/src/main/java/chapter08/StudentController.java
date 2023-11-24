package chapter08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/student/index3.do")
	public String index3(Model model, StudentVO vo) {
		model.addAttribute("list", service.search2(vo));
		model.addAttribute("total", service.count(vo));
		log.debug("로그테스트");
		return "student/index";
	}
}

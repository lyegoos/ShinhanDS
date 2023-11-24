package chapter07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/student/index.do")
	public String index(Model model) {
		model.addAttribute("list", service.all());	//jsp에서 꺼내쓸때 list라는 이름으로 꺼내써야지~
		return "student/index";
	}
}

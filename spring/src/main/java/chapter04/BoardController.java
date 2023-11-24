package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
		
	public void list() {
		service.selectArticles();
	}
}

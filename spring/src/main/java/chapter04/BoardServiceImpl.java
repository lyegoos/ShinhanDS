package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
//@Service
public class BoardServiceImpl implements BoardService {

//	@Autowired
	private BoardDAO dao;
	@Override
	public void selectArticles() {
		dao.selectArticles();
	}

}

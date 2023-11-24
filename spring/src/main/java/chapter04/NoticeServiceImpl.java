package chapter04;

import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements BoardService {

	@Override
	public void selectArticles() {
		System.out.println("공지사항 목록");
	}

}

package kr.co.project.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class ReplyServiceImpl implements ReplyService {

	// 아몰라 시발 뭐가 느려
	
	
	@Override
	public Map<String, Object> list(ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ReplyVO vo, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReplyVO view(ReplyVO vo, boolean isViewcntIncrease) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

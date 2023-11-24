package kr.co.project.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ReplyService {
	Map<String, Object> list(ReplyVO vo);
	int insert(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	ReplyVO view(ReplyVO vo, boolean isViewcntIncrease);
	int update(ReplyVO vo);
	int delete(ReplyVO vo);
	int reply(ReplyVO vo);
	
}

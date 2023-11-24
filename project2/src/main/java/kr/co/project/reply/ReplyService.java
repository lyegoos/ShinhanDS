package kr.co.project.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ReplyService {
	Map<String, Object> list(ReplyVO vo);
	int insert(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	ReplyVO view(ReplyVO vo, boolean isViewcntIncrease);
	int update(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	int delete(ReplyVO vo, HttpServletRequest request);
	int reply(ReplyVO vo, MultipartFile file, HttpServletRequest request);
}

package kr.co.project.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
	int count(ReplyVO vo);
	List<ReplyVO> list(ReplyVO vo);
	ReplyVO detail(int no);
	int updateViewcnt(int no);
	int update(ReplyVO vo);
	int delete(int no);
	int insert(ReplyVO vo);
	int updateGno(int no);
	int updateOno(ReplyVO vo);
	int reply(ReplyVO vo);
	int fileDelete(int no);
}

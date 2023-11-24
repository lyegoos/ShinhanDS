package kr.co.project.reply;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class ReplyVO {
	private int no;
	private String title;
	private String content;
	private Timestamp writedate;
	private int viewcnt;
	private String filename_org;
	private String filename_real;
	private int likecnt;
	private int user_no;
	private int gno;	// 그룹번호
	private int ono;	// 그룹내 순서
	private int nested;	// 들여쓰기 정도
	
	private int page;	// 페이지번호
	private int startIdx;
	private String searchType;
	private String searchWord;
//	private int rowPage;	// 한 페이지에 보이는 개수
	
	public ReplyVO() {
		this.page = 1;	// 생성자로 반드시 page를 1로 초기화. 처음 들어갔을때 1로 지정하지 않으면 null이 들어가므로 0이 들어가는데, 그래서 1을 생성자로 넣어준다.
	}
	
	public int getStartIdx() {
		return (page-1) * 10;
	}

	
}

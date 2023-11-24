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
	private int gno;
	private int ono;
	private int nested;
	
	private int page;
	private int startIdx;
	private String searchType;
	private String searchWord;
	
	private String user_name;
	private int comment_count;
	
	public ReplyVO() {
		this.page = 1;
	}
	
	public int getStartIdx() {
		return (page-1) * 10;
	}
}

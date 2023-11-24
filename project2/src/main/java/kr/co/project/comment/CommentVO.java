package kr.co.project.comment;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentVO {
	private int no;
	private int parent_no;
	private String content;
	private Timestamp writedate;
	private int user_no;
	private String user_name;
	
	private int startIdx;
	private int page;
}

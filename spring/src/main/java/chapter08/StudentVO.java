package chapter08;

import lombok.Data;

@Data
public class StudentVO {
	private int studno;
	private String name;
	private String id;
	private String telephone;
	private int grade;
	
	
	//검색 용도
	private String sgrade;	//학년, 검색관련된건 String으로 하자
	private String searchType;	//검색타입
	private String searchWord;	//검색어
}

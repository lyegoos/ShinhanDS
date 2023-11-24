package kr.co.project.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	// 이메일 중복체크
	int dupEmail(String email); //셀렉트시 카운트 쓸거니까 int. 중복이면 true로 하고 중복이 없으면 false로 처리하자 -> true면 가입이 안 되게 해야지
	// 회원가입
	int regist(UserVO vo);
	// 로그인 ( 파라미터가 id, pwd )
	// 세션에 담을거니까 리턴타입을 객체로
	UserVO login(UserVO vo); // 매개변수 1개만 가능, Map에 담던 VO에 담던 가능
	// 회원조회 ( 파라미터가 pk임 로그인과 다르다 )
	UserVO detail(int no);
	// 회원수정
	int update(UserVO vo);
}
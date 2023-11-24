package chapter08;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper		// 이 어노테이션을 안 쓰면 스캔 중에 에러가 날 수 있다.
public interface StudentMapper {

	List<StudentVO> search2(StudentVO vo);	//id="search2"
	int count(StudentVO vo);	//id="count"
	
	List<Map> all(); //all은 매개변수가 없으니까 이렇게 쓰면 됨
}

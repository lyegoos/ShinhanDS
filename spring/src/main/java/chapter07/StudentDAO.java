package chapter07;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public List<StudentVO> all(){
		return sst.selectList("student.all");
	}
}

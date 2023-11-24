package chapter07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	//DAO가 필요하므로 주입받는다.
	@Autowired
	private StudentDAO dao;
	
	public List<StudentVO> all(){
		return dao.all();
	}
}

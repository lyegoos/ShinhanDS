package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("adminDAO")
	private MemberDAO dao;
	
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.dao = memberDAO;
	}
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.dao = memberDAO;
	}
	@Override
	public void listMembers() {
		dao.listMembers();
	}

}
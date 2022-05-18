package spring02_me2;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("이미 존재하는 이메일입니다."+req.getEmail());
		}
		Member newMember = new Member(req.getEmail(),req.getPassword(),req.getName(),new Date());
		
		memberDao.insert(newMember);
	}
	
}

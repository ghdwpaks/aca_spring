package spring;

import javax.annotation.Resource;

public class MemberInfoPrinter {
	
	//@Autowired
	//@Resource
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public void setMemDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//@Autowired(required = false)
	//@Qualifier("print3")
	
	//@Resource(name="memberPrinter3")
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("정보가 존재하지 않습니다.");
			return;
		}
		memberPrinter.print(member);
		System.out.println();
	}
}

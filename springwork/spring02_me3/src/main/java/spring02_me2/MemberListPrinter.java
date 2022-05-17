package spring02_me2;

import java.util.List;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		super();
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		List<Member> members = memberDao.selectAll();
		for(Member m : members) {
			printer.print(m);
		}
	}
	
	
}

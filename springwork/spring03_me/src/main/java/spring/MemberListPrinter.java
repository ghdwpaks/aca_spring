package spring;

import java.util.ArrayList;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void memberListPrinter(MemberDao memberDao,MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		ArrayList<Member> members = memberDao.selectAll();
		for(Member m : members) {
			printer.print(m);
		}
	}
	
	
}


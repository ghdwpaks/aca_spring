package spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		System.out.println("MemberListPrinter()");
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

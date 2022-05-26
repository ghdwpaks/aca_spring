package spring;

import org.springframework.stereotype.Component;

@Component
public class MemberPrinter {
	
	public MemberPrinter() {
		System.out.println("MemberPrinter()");
	}
	
	public void print(Member member) {
		System.out.printf("회원정보: ID=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), 
				member.getEmail(), 
				member.getName(), 
				member.getRegisterDate());
	}
}

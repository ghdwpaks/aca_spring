package spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig2;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig2.class);
		
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("tester@tester.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		regSvc.regist(regReq); //멤버 등록
		infoPrinter.printMemberInfo("tester@tester.com"); //멤버 검색
	}
}

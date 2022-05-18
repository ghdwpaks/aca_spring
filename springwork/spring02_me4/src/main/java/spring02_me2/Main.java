package spring02_me2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx.xml"); 
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("tester@tester.com");
		regReq.setName("ghdwpaks");
		regReq.setPassword("5678");
		regReq.setConfirmPassword("5678");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("tester@tester.com");
	}

}

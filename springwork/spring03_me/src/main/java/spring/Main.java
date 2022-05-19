package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =ctx.getBean("infoPrinter",MemberInfoPrinter.class); 
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("tester@tester.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);
		infoPrinter.printMemberInfo("tester@tester.com");
		
		
	}

}

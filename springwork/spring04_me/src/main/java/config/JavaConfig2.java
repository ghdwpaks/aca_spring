package config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig2 {

	
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrinter printer()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
		
	}
	
}

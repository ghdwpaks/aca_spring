package config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class ConfigPartSub {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter printer()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao);
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
		
	}
	
}

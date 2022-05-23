package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		String email = "tester@test.com";
		Member result = memberDao.selectByEmail(email);
		System.out.println(result);
		System.out.println(memberDao.selectByEmail("test"));
	}
		
}

package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUpdate {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		String email = "tester@test.com";
				
		memberDao.update(new Member("tester@test.com", "4321", "HGD", null));
		Member result = memberDao.selectByEmail(email);
		System.out.println(result);
		
		memberDao.update2(new Member("tester@test.com", "2143", "HHH", null));
		result = memberDao.selectByEmail(email);
		System.out.println(result);
	}
		
}

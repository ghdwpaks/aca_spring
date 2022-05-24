package spring;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSelect {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		String email = "tester@test.com";
		Member result = memberDao.selectByEmail(email);
		System.out.println(result);
		System.out.println(memberDao.selectByEmail("test"));
		
		List<Member> ls = memberDao.selectAll(); //직접 구현해보기!
		System.out.println("정보 출력~");
		for(Member member : ls) {
			System.out.println(member.getId() + "-" + member.getEmail());
		}
		
		System.out.println(memberDao.count());
		System.out.println(memberDao.selectById(1L));
	}
		
}

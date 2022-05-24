package spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainInsert {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Scanner in = new Scanner(System.in);
		System.out.print("이메일:");
		String email = in.nextLine();
		System.out.print("비밀번호:");
		String password = in.nextLine();
		System.out.print("이름:");
		String name = in.nextLine();
		Member member = new Member(email, password, name, null);
		System.out.println(member.getId()); //ID지정되지 않음
		memberDao.insert(member);	//삽입
		System.out.println(member.getId()); //키 홀더를 통해 가져온 ID값 확인
	}
		
}






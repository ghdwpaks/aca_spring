package spring02_me2;

public class MainTest {
	public static void main(String[] args) {
		Assembler as = new Assembler();
		MemberRegisterService svc = as.getMemberRegisterService();
		
		RegisterRequest rr = new RegisterRequest();
		rr.setEmail("garnet2929@naver.com");
		rr.setPassword("1234");
		rr.setConfirmPassword("1234");
		rr.setName("홍길동");
		svc.regist(rr);
		
		
	}
}

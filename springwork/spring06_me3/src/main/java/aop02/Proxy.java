package aop02;

public class Proxy implements Person{
	
	private Person del;
	
	
	
	

	public Proxy(Person del) {
		this.del = del;
	}

	public int usingComputer(String pwd) {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터 부팅 후 "+pwd+"를 입력하여 로그인");
		return del.usingComputer(pwd);
	}
	
	
	
	
}

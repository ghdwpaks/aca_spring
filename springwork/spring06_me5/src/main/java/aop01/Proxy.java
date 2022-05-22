package aop01;

public class Proxy implements Person{

	private Person delegate;
	
	public Proxy(Person delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public int usingComputer(String pwd) {
		System.out.println("컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인");
		return delegate.usingComputer(pwd);
	}
	
}

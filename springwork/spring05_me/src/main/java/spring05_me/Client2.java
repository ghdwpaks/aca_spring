package spring05_me;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2.setHost() 실행");
	}
	
	public void send() {
		System.out.println("Client2.send() to "+host);
	}
	
	
	public void finish() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client2.finish() 실행");
	}

	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Client2.init() 실행");
	}
	
}

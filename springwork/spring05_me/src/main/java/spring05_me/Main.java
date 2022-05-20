package spring05_me;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring-conf.xml"); 
		System.out.println("컨테이너 생성");
		Client client = ctx.getBean("client",Client.class);
		System.out.println("빈 가져오기");
		client.send();
		ctx.close();
		System.out.println("프로그램 종료");
		
	}
	

}


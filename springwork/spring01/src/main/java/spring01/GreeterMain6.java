package spring01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GreeterMain6 {
	public static void main(String[] args) {
		
		//스프링 컨텍스트(컨테이너)
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx4.xml");
		
		Greeter gr = ctx.getBean("greeter", Greeter.class);	
		String result = gr.greet("홍길동");
		// 홍길동님 안녕하세요 가 반환됨
		System.out.println(result);
	}
}

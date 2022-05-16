package spring01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GreeterMain3 {
	public static void main(String[] args) {
		
		//스프링 컨텍스트(컨테이너)
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx.xml");
		
		Greeter gr1 = ctx.getBean("greeter", Greeter.class);			
		Greeter gr2 = ctx.getBean("greeter", Greeter.class);
		//Greeter객체는 몇 개?
		System.out.println(gr1);  
		System.out.println(gr2);
		System.out.println(gr1 == gr2);
	}
}

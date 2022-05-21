package aop02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop02.xml"); 
		
		//Person a = ctx.getBean("programmer",Person.class);
		//Person b = ctx.getBean("proGamer",Person.class);
		
		Person a = new Proxy(new Programmer());
		Person b = new Proxy(new ProGamer());
		
		
		//useTime
		int ut1 = a.usingComputer("1234");
		System.out.println("a의 사용시간 : " +ut1);
		
		System.out.println("================");
		
		int ut2 = b.usingComputer("5678");
		System.out.println("b의 사용시간 : " +ut2);	
		
		
	}

}

package aoptest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aoptest.xml"); 
		//Calculator c1 = new ImplCal1();
		Calculator c1 = ctx.getBean("imca",ImplCal1.class);
		//Calculator c2 = new RecuCal();
		Calculator c2 = ctx.getBean("reca",RecuCal.class);
		
				
		
		int n = 5;
		System.out.println(c1.factorial(n));
		System.out.println(c2.factorial(n));
		
	}

}

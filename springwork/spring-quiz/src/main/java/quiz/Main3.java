package quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx2.xml");
		Calculator cal = ctx.getBean("calc", Calculator.class);
		int n1 = 2;
		int n2 = 3;
		
		System.out.println(cal.add(n1, n2));
		System.out.println(cal.min(n1, n2));
		System.out.println(cal.mul(n1, n2));
		System.out.println(cal.div(n1, n2));
		
		cal.printCounter();
		
		ctx.close(); 
	}
}

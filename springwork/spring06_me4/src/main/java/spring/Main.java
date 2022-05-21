package spring;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator impl1 = new CalculatorImpl1();
		Calculator impl2 = new CalculatorImpl2();
		
		System.out.println(impl1.add(10));
		System.out.println(impl2.add(10));
		
		
	}

}


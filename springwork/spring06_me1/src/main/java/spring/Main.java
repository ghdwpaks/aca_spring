package spring;

public class Main {
	public static void main(String[] args) {
		Calculator im1 = new CalculatorImpl1();
		Calculator im2 = new CalculatorImpl2();
		
		System.out.println(im1.add(10));
		System.out.println(im2.add(10));
		
	}
}

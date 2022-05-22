package aoptest2;

public class Main {
	public static void main(String[] args) {
		Calculator c1 = new ImplCal1();
		Calculator c2 = new RecuCal();
		
		int n = 5;
		System.out.println(c1.factorial(n));
		System.out.println(c2.factorial(n));
		
	}

}

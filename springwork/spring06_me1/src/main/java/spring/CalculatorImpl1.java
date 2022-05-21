package spring;

public class CalculatorImpl1 implements Calculator {

	public int add(int n) {
		int ret = 0;
		for(int i = 1; i <= n; i++) {
			ret += i;
		}
		return ret;
	}
	

}

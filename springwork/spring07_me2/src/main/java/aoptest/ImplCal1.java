package aoptest;

public class ImplCal1 implements Calculator{

	@Override
	public long factorial(long num) {
		
		long r = 1;
		for(int i = 1; i<=num;i++) {
			r *= i;
		}
		
		return r;
	}
	
	

}

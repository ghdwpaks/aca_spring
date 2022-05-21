package spring;

public class CalculatorImpl1 implements Calculator{

	
	public int add(int n1) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int ret = 0;
		for(int i = 0; i <= n1 ; i++) {
			ret += i;
		}
		
		long end = System.currentTimeMillis();
		System.out.println("impl1 :"+(end-start));
		return ret;
	}
	
	
	

}

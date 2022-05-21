package spring;

public class CalculatorImpl2 implements Calculator{

	
	public int add(int n) {
		// TODO Auto-generated method stub
		if(n==1) {
			return n;
		}
		return add(n-1)+n;
		
	}
	
	
	

}

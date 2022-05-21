package spring;

public class ExecTimeCalculator implements Calculator{
	
	private Calculator delegate;
	
	public ExecTimeCalculator(Calculator delegate) {
		
	}
	
	public int add(int n) {
		
		int ret = delegate.add(n);
		
		return 0;
	}
	

}

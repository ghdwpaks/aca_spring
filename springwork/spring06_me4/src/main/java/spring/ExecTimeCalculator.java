package spring;

//프록시 객체. 대행자!
public class ExecTimeCalculator implements Calculator{
	private Calculator delegate;
	
	public ExecTimeCalculator (Calculator delegate) {
		this.delegate = delegate;
	}

	public int add(int n) {
		long start = System.nanoTime();
		int ret = delegate.add(n);
		
		long end = System.nanoTime();
		System.out.println("시간 : "+(end-start));
		
		return ret;
	}
	
	
	

}

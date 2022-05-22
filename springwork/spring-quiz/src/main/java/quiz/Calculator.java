package quiz;

public class Calculator {
	
	private Counter addCnt;
	private Counter minCnt;
	private Counter mulCnt;
	private Counter divCnt;
	
	public Calculator() {}
	
	public Calculator(Counter addCnt, Counter minCnt, Counter mulCnt, Counter divCnt){
		this.addCnt = addCnt;
		this.minCnt = minCnt;
		this.mulCnt = mulCnt;
		this.divCnt = divCnt;
	}
	
	public void setAddCnt(Counter addCnt) {
		this.addCnt = addCnt;
	}
	public void setMinCnt(Counter minCnt) {
		this.minCnt = minCnt;
	}
	public void setMulCnt(Counter mulCnt) {
		this.mulCnt = mulCnt;
	}
	public void setDivCnt(Counter divCnt) {
		this.divCnt = divCnt;
	}

	public int add(int n1, int n2) {
		addCnt.increment();
		return n1 + n2;
	}
	public int min(int n1, int n2) {
		minCnt.increment();
		return n1 - n2;
	}
	public int mul(int n1, int n2) {
		mulCnt.increment();
		return n1 * n2;
	}
	public int div(int n1, int n2) {
		divCnt.increment();
		return n1 / n2;
	}
	
	public void printCounter() {
		System.out.println("add:" + addCnt.getCnt());
		System.out.println("min:" + minCnt.getCnt());
		System.out.println("mul:" + mulCnt.getCnt());
		System.out.println("div:" + divCnt.getCnt());
	}
}

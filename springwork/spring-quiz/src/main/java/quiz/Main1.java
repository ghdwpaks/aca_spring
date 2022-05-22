package quiz;

public class Main1 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int n1 = 2;
		int n2 = 3;
		cal.setAddCnt(new Counter());
		cal.setMinCnt(new Counter());
		cal.setMulCnt(new Counter());
		cal.setDivCnt(new Counter());
		
		System.out.println(cal.add(n1, n2));
		System.out.println(cal.min(n1, n2));
		System.out.println(cal.mul(n1, n2));
		System.out.println(cal.div(n1, n2));
	}
}

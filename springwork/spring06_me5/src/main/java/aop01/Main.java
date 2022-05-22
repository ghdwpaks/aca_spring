package aop01;

public class Main {
	public static void main(String[] args) {
		//Programmer alice = new Programmer();
		//ProGamer bob = new ProGamer();
		
		Person alice = new Proxy(new Programmer());
		Person bob = new Proxy(new ProGamer());
		
		int useTime1 = alice.usingComputer("1234");
		System.out.println("alice의 사용 시간:" + useTime1);
		
		System.out.println("==========");
		
		int useTime2 = bob.usingComputer("5678");
		System.out.println("bob의 사용 시간:" + useTime2);
	}
}

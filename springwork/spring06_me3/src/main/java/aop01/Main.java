package aop01;

public class Main {
	public static void main(String[] args) {
		Programmer a = new Programmer();  
		ProGamer b = new ProGamer();
		
		//useTime
		int ut1 = a.usingComputer("1234");
		System.out.println("a의 사용시간 : " +ut1);
		
		System.out.println("================");
		
		int ut2 = b.usingComputer("5678");
		System.out.println("a의 사용시간 : " +ut2);	
		
		
	}

}

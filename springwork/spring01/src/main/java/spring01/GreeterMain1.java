package spring01;

public class GreeterMain1 {
	public static void main(String[] args) {
		Greeter gr = new Greeter();	
		
		
		
		
		gr.setFormat("%s님 안녕하세요!");
		String result = gr.greet("홍길동");
		// 홍길동님 안녕하세요 가 반환됨
		System.out.println(result);
	}
}

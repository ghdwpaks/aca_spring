package spring01;

public class Greeter {
	private String format;
	
	public Greeter() {
		System.out.println("Greeter()");
	}
	
	public Greeter(String format) {
		System.out.println("Greeter(String)");
		this.format = format;
	}
	
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
	public void setFormat(String format) {
		System.out.println("setFormat()");
		this.format = format;
	}
}

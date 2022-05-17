package spring02_me2;

public class AlreadyExistingMemberException extends RuntimeException{
	public AlreadyExistingMemberException(String message) {
		super(message);
	}

}

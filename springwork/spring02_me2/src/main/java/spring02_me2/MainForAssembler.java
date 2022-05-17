package spring02_me2;

import java.util.Scanner;

public class MainForAssembler {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("명령어 입력 :");
			String command = in.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
			}
		}
	}
	
	private static void processChangeCommand(String[] cmd) { 
		if(cmd.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService pwdSvc = assembler.getChangePasswordService();
		try {
			pwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
			System.out.println("비밀번호가 변경됐습니다.");
			
		} catch (MemberNotFoundException e) {
			// TODO: handle exception
			throw new IdPasswordNotMatchingException();
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.");
			return;
		}
		
	}
	

	private static Assembler assembler = new Assembler();

	private static void processNewCommand(String[] cmd) {
		if(cmd.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setName(cmd[2]);
		req.setPassword(cmd[3]);
		req.setConfirmPassword(cmd[4]);
		 
		if(!req.isPasswordEqualsToConfirmPassword()) {
			System.out.println("비밀번호 확인");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록됐습니다.");
		} catch(AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printHelp() {
		System.out.println("사용법");
		System.out.println("new <이메일> <이름> <비밀번호> <비밀번호 확인>");
		System.out.println("change <이메일> <현재 비밀번호> <변경할 비밀번호>");
		
	}

}

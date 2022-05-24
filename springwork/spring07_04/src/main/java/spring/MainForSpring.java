package spring;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("명령어 입력:");
			String command = in.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
			}else if(command.equals("list")) {
				processListCommand();
			}else if(command.startsWith("info")) {
				processInfoCommand(command.split(" "));
			}else if(command.equals("version")) {
				processVersionCommand();
			}
		}
	}
	
	private static void processVersionCommand() {
		VersionPrinter vp = ctx.getBean("versionPrinter", VersionPrinter.class);
		vp.print();
	}

	private static void processInfoCommand(String[] cmd) {
		if(cmd.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(cmd[1]);
	}

	private static void processListCommand() {
		MemberListPrinter listPrinter = 
				ctx.getBean("memberListPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}

	private static GenericXmlApplicationContext ctx =
						new GenericXmlApplicationContext("classpath:applicationContext.xml"); 

	private static void processNewCommand(String[] cmd) {
		if(cmd.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegisterService", MemberRegisterService.class);
		
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
			System.out.println("등록되었습니다.");
		}catch(AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void processChangeCommand(String[] cmd) {
		if(cmd.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService pwdSvc = 
				ctx.getBean("changePasswordService", ChangePasswordService.class);
		try {
			pwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("이메일이 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.");
		}
	}


	private static void printHelp() {
		System.out.println("사용법");
		System.out.println("new <이메일> <이름> <비밀번호> <비밀번호 확인>");
		System.out.println("change <이메일> <현재 비밀번호> <변경할 비밀번호>");
		System.out.println("list");
		System.out.println("info <이메일>");
	}
}

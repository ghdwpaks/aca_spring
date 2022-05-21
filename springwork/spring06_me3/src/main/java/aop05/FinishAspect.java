package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FinishAspect {
	
	@After("executon(* usingComputer(..))")
	public void shutdown(JoinPoint jp) {
		String computer = (String) jp.getTarget().getClass().getSimpleName();
		System.out.println(computer+"시스템 종료");
		
		
		
	}
	

}

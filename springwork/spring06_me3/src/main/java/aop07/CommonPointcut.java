package aop07;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {

	@Pointcut("execution(* usingComputer(..))")
	public void myPointcut() {}
}

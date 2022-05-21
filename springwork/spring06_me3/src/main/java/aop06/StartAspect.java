package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StartAspect {
	
	//@Before("execution(public int aop02.*.usingComputer(String, int)")
	//이렇게 인자를 두개 이상을 꺼낼 수도 있고, jp.getArgs()[0]; 에서 배열인덱스 값을 조절해서 꺼내고, 캐스팅을 적절히 하면 된다.
	
	@Before("execution(public int aop05.*.usingComputer(String)")
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 "+pwd+"를 입력하여 로그인");
	}
}

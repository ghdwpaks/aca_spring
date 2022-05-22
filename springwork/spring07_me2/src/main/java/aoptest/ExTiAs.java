package aoptest;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExTiAs {
	public Object m(ProceedingJoinPoint pjp) throws Throwable{
		long s = System.nanoTime();
		try {
			Object r =  pjp.proceed();
			return r;
		} finally {
			long f = System.nanoTime();
			System.out.printf("%s, %s(%s) 실행시간 : %dns\n",pjp.getTarget().getClass().getSimpleName(),pjp.getSignature().getDeclaringTypeName(),Arrays.toString(pjp.getArgs()),(f-s));
			
		} 
		
		
	}
}

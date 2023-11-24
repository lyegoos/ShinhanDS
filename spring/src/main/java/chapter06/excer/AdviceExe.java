package chapter06.excer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdviceExe {
	@Pointcut("execution(public * chapter06.excer..*(..))")
	public void publicTarget() {};
	
	@Around("publicTarget()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
		Object obj = null;
		System.out.println("메서드 실행전");
		long start = System.nanoTime();
		
		obj = joinPoint.proceed(); // 실제 메서드 실행
		
		long end = System.nanoTime();
		System.out.println("AOP : "+(end-start));
		System.out.println("메서드 실행후");
		return obj;
	}
}

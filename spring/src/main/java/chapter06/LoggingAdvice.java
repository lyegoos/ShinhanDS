package chapter06;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LoggingAdvice");
		System.out.println("무언가1");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed();
		
		System.out.println("무언가2");
		System.out.println("[메서드 호출 후 : logginAdvice");
		System.out.println(invocation.getMethod() + " 메서드 호출 후");
		return object;
	}
}

package chapter06.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter06.excer.Calculator;
import chapter06.excer.Calculator2Exe;
import chapter06.excer.CalculatorImpl;
import chapter06.excer.CalculatorImpl2;

public class Main {

	public static void main(String[] args) {
//		Calculator cal = new CalculatorImpl();
//		long r = cal.factorial(10);
//		System.out.println(r);
		
//		AnnotationConfigApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(AppCtx.class);
//		Calculator cal = ctx.getBean("calculator", Calculator.class);
//		cal.factorial(10);
		
//		CalculatorImpl2 cal = new CalculatorImpl2();
//		Calculator2Exe calExe = new Calculator2Exe(cal);
//		calExe.factorial(10);
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		Calculator cal = ctx.getBean("calculator2", Calculator.class);
		cal.factorial(10);
		System.out.println(cal.getClass());
	}

}

package chapter06.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06.excer.AdviceExe;
import chapter06.excer.Calculator;
import chapter06.excer.CalculatorImpl;
import chapter06.excer.CalculatorImpl2;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

	@Bean
	public Calculator calculator() {
		return new CalculatorImpl();
	}
	
	@Bean
	public Calculator calculator2() {
		return new CalculatorImpl2();
	}
	
	@Bean
	public AdviceExe adviceExe() {
		return new AdviceExe();
	}
}

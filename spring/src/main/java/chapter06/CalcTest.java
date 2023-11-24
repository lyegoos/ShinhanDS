package chapter06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter06/AOPTest.xml");
		Calculator cal = (Calculator)ctx.getBean("proxyCal");
		cal.add(100,20);
		System.out.println();
		cal.subtract(100,20);
		System.out.println();
		cal.multiply(100,20);
		System.out.println();
		cal.divide(100,20);
		
		Calculator cal2 = new Calculator();
		System.out.println(cal.getClass().getName());
		System.out.println(cal2.getClass().getName());
	}

}

package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		
		//class를 읽어들여서 bean 객체를 생성해서 bean 컨테이너에 저장
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		
		PersonService personService = (PersonService)ctx.getBean("personService");
		personService.sayHello();
		
		PersonService personService2 = (PersonService)ctx.getBean("personService");
		
		System.out.println(personService == personService2);		// true
		
		
	}
	

}

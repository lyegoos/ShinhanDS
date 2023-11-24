package chapter01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {

		public static void main(String[] args) {
			//xml(빈 설정파일) 을 읽어들임
			//모든 빈 객체를 생성시켜서 bean container에 저장
//			BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/java/person.xml"));
			
			ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("chapter01/person.xml");
			
			//container에서 id로 꺼낸다(get)
			PersonService person = (PersonService)factory.getBean("personService");
			person.sayHello();
			
			//처음에 container에 만들어둔 객체를 꺼내 쓰는 것임으로 같은 객체이다.
			PersonService person2 = (PersonService)factory.getBean("personService");
			System.out.println(person == person2);
			person2.sayHello();
			
			PersonService person3 = factory.getBean("personService", PersonService.class);
			
			
			//매개변수 1개짜리 생성자
			PersonService service1 = factory.getBean("personService1", PersonService.class);
			service1.sayHello();

			//매개변수 2개짜리 생성자
			PersonService service2 = factory.getBean("personService2", PersonService.class);
			service2.sayHello();
			
			
		}
		
		
}

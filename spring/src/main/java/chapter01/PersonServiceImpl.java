package chapter01;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
//@NoArgsConstructor
public class PersonServiceImpl implements PersonService {
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl() {}
	
	@Override
	public void sayHello() {
		
		System.out.println("�씠由� : " + name);
		System.out.println("�굹�씠 : " + age);

	}
	
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}

}

package kr.co.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEX {

	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void test() {
		System.out.println("테스트");
		int count = 10;
		
		assertEquals(10,  count);	//10을 기대했는데 10임

	}
	
	@Test
	public void test2() {
		System.out.println("테스트2");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("처음 한번만");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("마지막 한번만");
	}
}

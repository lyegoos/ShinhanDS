package chapter06;

public class Calculator {
	public void add(int x, int y) {
		// 무언가1
		int result = x + y;
		System.out.println("결과 : "+result);
		// 무언가2
	}
	public void subtract(int x, int y) {
		// 무언가1
		int result = x - y;
		System.out.println("결과 : "+result);
		// 무언가2
	}
	public void multiply(int x, int y) {
		int result = x * y;
		System.out.println("결과 : "+result);
	}
	public void divide(int x, int y) {
		int result = x / y;
		System.out.println("결과 : "+result);
	}
}

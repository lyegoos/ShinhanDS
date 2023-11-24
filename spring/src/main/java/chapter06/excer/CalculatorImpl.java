package chapter06.excer;

public class CalculatorImpl implements Calculator {

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
//		(4-1) => 3*(3-1) => 2*(2-1) 
		
		long result = 1;
		for (int i=1; i<=num; i++) {
			result *= i;
		}
		
		long end = System.nanoTime();
		System.out.println("for문 : "+(end-start));
		return result;
	}

}

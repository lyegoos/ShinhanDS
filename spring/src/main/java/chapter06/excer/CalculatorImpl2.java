package chapter06.excer;

public class CalculatorImpl2 implements Calculator {

	@Override
	public long factorial(long num) {
//		long start = System.nanoTime();
		
		if (num == 0) {
			return 1;
		} else {
			return num * factorial(num-1);
		}
		// 4! -> 4*(4-1) -> 3*(3-1) -> 2*(2-1)
		
//		long end = System.nanoTime();
//		System.out.println("for문 : "+(end-start));
	}

}

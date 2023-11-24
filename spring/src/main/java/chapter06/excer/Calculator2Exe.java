package chapter06.excer;

public class Calculator2Exe implements Calculator {
	
	private Calculator cal;
	public Calculator2Exe(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long r = cal.factorial(num);   //재귀가 올지 아니면 그냥 곱한 함수가 올지,, 뭐가 들어오느냐에 따라서 다르다
		long end = System.nanoTime();
		System.out.println("factorial : "+(end-start));
		return r;
	}

}
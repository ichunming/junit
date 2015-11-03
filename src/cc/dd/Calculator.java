package cc.dd;

public class Calculator {
	private static int result;
	
	public void add(int num) {
		result += num;
	}

	public void substract(int num) {
		result -= 1; //bug: 正确的应该是 result -= num
	}

	public void multiply(int num) {
		
	} //尚未写好
	
	public void divide(int num) {
		result /= num;
	}
	
	public void square(int num) {
		result = num * num;
	}
	
	public void squareRoot() {
		for(; ;) {
			
		}//bug:死循环
	}
	
	public void clear() {
		result = 0;
	}
	
	public void tearDown() {
		result = 1;
	}
	
	public int getResult() {
		return result;
	}
}

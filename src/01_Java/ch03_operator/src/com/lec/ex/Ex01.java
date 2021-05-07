package com.lec.ex;

// 산술 연산자(+,-,*,/,%)
public class Ex01 {
	
	public static void main(String[] args) {
		
		int n1 = 33, n2 = 10;
		int result;
		double resultDoule;
		
		result = n1 + n2;
			System.out.printf("%d %c %d = %d \n", n1, '+', n2, result);
		
		result = n1 - n2;
			System.out.printf("%d %c %d = %d \n", n1, '-', n2, result);
		
		result = n1 * n2;
			System.out.printf("%d %c %d = %d \n", n1, '*', n2, result);
		
		result = n1 / n2;
			System.out.printf("%d %c %d = %d \n", n1, '/', n2, result);
		
		result = n1 % n2;
			System.out.printf("%d %c %d = %d \n", n1, '%', n2, result);
		
			
		// 나머지 연산자(%)의 쓰임새	
		if(n1%2 == 0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
	} // main함수 끝

} // class 끝

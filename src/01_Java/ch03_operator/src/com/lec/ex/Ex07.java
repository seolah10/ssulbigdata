package com.lec.ex;

// 비트 연산자 : &, |
public class Ex07 {
	
	public static void main(String[] args) {
		
		int n1 = 10;		  // 0 ~ 0 1 0 1 0
		int n2 = 5;			  // 0 ~ 0 0 1 0 1 
		
		int result = n1 & n2; // 0 ~ 0 0 0 0 0
				System.out.printf("%d %c %d = %d\n", n1, '&', n2, result);

		    result = n1 | n2; // 0 ~ 0 1 1 1 1		
		    System.out.printf("%d %c %d = %d\n", n1, '|', n2, result);
	}

}

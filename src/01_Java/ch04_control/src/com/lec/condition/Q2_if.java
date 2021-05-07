package com.lec.condition;

// 두 수 중 큰 수를 변수 max에 입력하고 그 수를 출력하기
public class Q2_if {
	
	public static void main(String[] args) {
		
		int num1 = 27;
		int num2 = 32;
		int max;
	
		if(num1  > num2) { 
			max = num1;
		}
		else {
			max = num2;
		}
		System.out.println(max);
	}

}

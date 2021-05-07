package com.lec.condition;

import java.util.Scanner;

// 수를 입력받아 절대값을 출력하기
public class Q1_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요. ");
		int num = sc.nextInt();
		
		if(num >=0) {
			System.out.println("절대값은 "+num);
		}
		else {
			System.out.println("절대값은"+(-1*num));
//			System.out.println("절대값은"+(-num));
		}
		sc.close();
	}

}

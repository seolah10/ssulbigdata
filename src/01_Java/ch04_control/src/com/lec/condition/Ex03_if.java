package com.lec.condition;
// 두 수 중 최대값이 무엇인지 출력하기
import java.util.Scanner;

public class Ex03_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("첫번째 수는? ");
			int num1 = sc.nextInt();
			
			System.out.println("두번째 수는? ");
			int num2 = sc.nextInt();
			
			if(num1 >= num2) { 
				System.out.println("입력하신 값들의 최대값은 "+num1);
			}
			else {
				System.out.println("입력하신 값들의 최대값은 "+num2);
			}
	}
}

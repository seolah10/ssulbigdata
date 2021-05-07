package com.lec.question;

import java.util.Scanner;

// 사용자로부터 숫자를 입력 받고, 입력 받은 수가 3의 배수인지 아닌지 파악하기
public class Q1 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				System.out.println("정수를 입력하세요: ");
				
			int i = sc.nextInt();
				System.out.println(i%3==0 ? "3의 배수입니다" : "3의 배수가 아닙니다");

		sc.close();
	}

}

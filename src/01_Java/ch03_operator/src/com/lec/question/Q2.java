package com.lec.question;

import java.util.Scanner;

// 입력한 수가 짝수인지 홀수인지 출력 
public class Q2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				System.out.println("숫자를 입력하세요: ");
				
			int num = sc.nextInt();
				System.out.println(num%2==0 ? "짝수" : "홀수");
		
		sc.close();
	}

}


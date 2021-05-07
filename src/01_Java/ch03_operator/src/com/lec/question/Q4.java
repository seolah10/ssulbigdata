package com.lec.question;

import java.util.Scanner;

// 입력받은 나이가 65세 이상이면 "경로우대", 아니면 "일반"
public class Q4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이가 어떻게 되세요? ");
		int age = sc.nextInt();
		
		System.out.println(((age>=65) ? "경로우대" : "일반"));

		sc.close();
	}

}

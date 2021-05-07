package com.lec.loop;

import java.util.Scanner;

// 원하는 구구단 식 출력하기
public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단을 원하세요?");
		int dansu = sc.nextInt();
		
		for(int i=1 ; i<10 ; i++) {
//			System.out.printf("%d*%d=%2d\n",dansu, i, dansu*i);
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		sc.close();
	}
}

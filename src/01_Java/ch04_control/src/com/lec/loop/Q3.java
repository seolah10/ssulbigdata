package com.lec.loop;

import java.util.Scanner;

// ���ϴ� ������ �� ����ϱ�
public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���� ���ϼ���?");
		int dansu = sc.nextInt();
		
		for(int i=1 ; i<10 ; i++) {
//			System.out.printf("%d*%d=%2d\n",dansu, i, dansu*i);
			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		sc.close();
	}
}

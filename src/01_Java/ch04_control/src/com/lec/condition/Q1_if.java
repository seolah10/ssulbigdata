package com.lec.condition;

import java.util.Scanner;

// ���� �Է¹޾� ���밪�� ����ϱ�
public class Q1_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڸ� �Է��ϼ���. ");
		int num = sc.nextInt();
		
		if(num >=0) {
			System.out.println("���밪�� "+num);
		}
		else {
			System.out.println("���밪��"+(-1*num));
//			System.out.println("���밪��"+(-num));
		}
		sc.close();
	}

}

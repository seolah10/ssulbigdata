package com.lec.question;

import java.util.Scanner;

// �Է��� ���� ¦������ Ȧ������ ��� 
public class Q2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				System.out.println("���ڸ� �Է��ϼ���: ");
				
			int num = sc.nextInt();
				System.out.println(num%2==0 ? "¦��" : "Ȧ��");
		
		sc.close();
	}

}


package com.lec.question;

import java.util.Scanner;

// ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���� 3�� ������� �ƴ��� �ľ��ϱ�
public class Q1 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				System.out.println("������ �Է��ϼ���: ");
				
			int i = sc.nextInt();
				System.out.println(i%3==0 ? "3�� ����Դϴ�" : "3�� ����� �ƴմϴ�");

		sc.close();
	}

}

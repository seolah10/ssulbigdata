package com.lec.question;

import java.util.Scanner;

// �Է¹��� ���̰� 65�� �̻��̸� "��ο��", �ƴϸ� "�Ϲ�"
public class Q4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���̰� ��� �Ǽ���? ");
		int age = sc.nextInt();
		
		System.out.println(((age>=65) ? "��ο��" : "�Ϲ�"));

		sc.close();
	}

}

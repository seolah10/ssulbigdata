package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01 {

	 public static void main(String[] args) {
			
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("���̸� �Է��ϼ���: ");
		 int age = sc.nextInt();
		 System.out.println("�Է��Ͻ� ���̴� "+age);

		 System.out.print("�̸��� �Է��ϼ���: ");
		 String name = sc.next(); // ���ۿ� ó�� ������ \n�� �����ϰ� whiteSpace������ ������ ����
		 System.out.println("�Է��Ͻ� �̸��� "+name);
		 
		 System.out.print("�ּҸ� �Է��ϼ���: ");
		 sc.nextLine(); // ���� �����(\n)
		 String address = sc.nextLine(); // ���ۿ� \n�� ������ �ձ��� ����
		 System.out.println("�Է��Ͻ� �ּҴ� "+address);
		 
		 System.out.println("===���α׷� ��===");
	}

}

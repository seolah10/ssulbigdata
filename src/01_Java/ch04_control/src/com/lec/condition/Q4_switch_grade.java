package com.lec.condition;

import java.util.Scanner;

//������ �Է¹޾� �ش� ������ �ش��ϴ� ���� ����ϱ�
public class Q4_switch_grade {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		int temp = grade==100 ? grade-1 : grade; // ������ 100���� ��� �����ϱ� ���� ����
		
		switch(temp/10) {
		
		case 9 :
				System.out.println("A"); break;

		case 8 :
				System.out.println("A"); break;
		
		case 7 :
				System.out.println("A"); break;
		
		case 6 :
				System.out.println("A"); break;
		
		case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
				System.out.println("A"); break;
				
		default: 
				System.out.println("��ȿ���� ���� �����Դϴ�");
		}
		sc.close();
	}

}

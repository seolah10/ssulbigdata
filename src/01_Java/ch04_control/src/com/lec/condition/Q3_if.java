package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� ����(0), ����(1), ��(2) �� �ϳ��� �Է¹ް�,
// ��ǻ�͵� ����(0), ����(1), ��(2) �� �ϳ��� �����Ͽ� ���ڸ� ����ϱ�
public class Q3_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����(0), ����(1), ��(2)!!");
		int you = sc.nextInt();
		
		if (you==0) { 
			System.out.println("������ ���̱�");
		}
		else if (you==1) {
			System.out.println("������ ���̱�");
		}
		else if (you==2) { 
			System.out.println("���� ���̱�");
		}
		else {
			System.out.println("����!");
			System.exit(0);
		}
		sc.close();
		
		int com = (int)(Math.random()*3);
		
		if(com==0) { 
			System.out.println("��ǻ�ʹ� ����");
		}
		else if(com==1) {
			System.out.println("��ǻ�ʹ� ����");
		}
		else {
			System.out.println("��ǻ�ʹ� ��");
		}
		
		if((you+2)%3 == com) { // 12.01 �����̵� ����
			System.out.println("����� �̰���!");
		}
		else if(you == com) {
			System.out.println("���׿�");
		}
		else {
			System.out.println("�ƽ��׿�~ ����� �����!");
		}

	 // �ϳ��� �����غ��� ���
//		if(you==0) {
//			if (com==0) {
//				System.out.println("���׿�");
//			}
//			else if (com==1) {
//				System.out.println("��ǻ�� ��!");
//			}
//			else {
//				System.out.println("��� ��!");
//			}
//		}
//		else if (you==1) {
//			if (com==0) {
//				System.out.println("��� ��!");
//			}
//			else if (com==1) { 
//				System.out.println("���׿�");
//			}
//			else {
//				System.out.println("��ǻ�� ��!");
//			}
//		}
//		else if (you==2) { 
//			if (com==2) {
//				System.out.println("��ǻ�� ��!");
//			}
//			else if (com==1) { 
//				System.out.println("��� ��!");
//			}
//			else {
//				System.out.println("���׿�");
//			} // com if��
//		} // you if��
	} // main �Լ�

}// class




















































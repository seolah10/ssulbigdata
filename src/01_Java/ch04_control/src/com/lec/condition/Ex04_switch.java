package com.lec.condition;
// �ֻ��� ������
public class Ex04_switch {

	public static void main(String[] args) {
		
		int num = 2;
		
		switch(num) {
			
		case 1:
				System.out.println("�ֻ��� 1"); break; // break�� ���� ������ �ش� ������ �Ʒ����� �� �� ��µȴ�.
	
		case 2:
				System.out.println("�ֻ��� 2"); break;
				
		case 3: 
				System.out.println("�ֻ��� 3"); break;
				
		default : 
				System.out.println("�� ��"); break;
		}
	}
		
}

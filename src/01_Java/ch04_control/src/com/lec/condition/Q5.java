package com.lec.condition;

import java.util.Scanner;

// ���� �� ������ Ű����� �Է¹޾� ������ ����ϱ�
public class Q5 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		switch(month) { // swtich������ ����ϱ�
		
			case 12: case 1: case 2:
				System.out.println("������ �ܿ��Դϴ�");
			
			case 3: case 4: case 5:
				System.out.println("������ ���Դϴ�");
			
			case 6: case 7: case 8:
				System.out.println("������ �����Դϴ�");
			
			case 9: case 10: case 11:
				System.out.println("������ �����Դϴ�");
			
			default: 
				System.out.println("����!");
		}
		
		if(month==12 || month==1 || month==2) { //if������ ����ϱ�
			System.out.println("������ �ܿ��Դϴ�");
		}
		else if(month==3 || month==4 || month==5) {
			System.out.println("������ ���Դϴ�");
		}
		else if(month==6 || month==7 || month==8) {
			System.out.println("������ �����Դϴ�");
		}
		else if(month==9 || month==10 || month==11) {
			System.out.println("������ ���Դϴ�");
		}
			System.out.println("����");
	}
}























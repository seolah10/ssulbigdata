package com.lec.condition;
// �� �� �� �ִ밪�� �������� ����ϱ�
import java.util.Scanner;

public class Ex03_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("ù��° ����? ");
			int num1 = sc.nextInt();
			
			System.out.println("�ι�° ����? ");
			int num2 = sc.nextInt();
			
			if(num1 >= num2) { 
				System.out.println("�Է��Ͻ� ������ �ִ밪�� "+num1);
			}
			else {
				System.out.println("�Է��Ͻ� ������ �ִ밪�� "+num2);
			}
	}
}

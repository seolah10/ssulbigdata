package com.lec.question;

import java.util.Scanner;

// �Է��� �� ���� �� �����ڵ��� �̿��Ͽ� ���� ����� true�� O, false�� X�� ����Ͻÿ�.
public class Q3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
				System.out.println("ù��° ��: ");
			int num1 = sc.nextInt();
			
				System.out.println("�ι�° ��: ");
			int num2 = sc.nextInt();
				
			String result = num1==num2 ? "0" : "X";
				System.out.println("num1 == num2 �� ����� "+result);
			
			boolean result2 = num1 > num2;
				System.out.println("num1 > num2�� ����� "+
								( (result2==true)? "O":"X") );
				
		sc.close();
					
	}

}

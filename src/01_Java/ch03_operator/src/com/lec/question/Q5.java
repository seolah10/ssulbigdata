package com.lec.question;

import java.util.Scanner;

// �� �� �� ���� ��� ���ϱ�
public class Q5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.print("���� ����: ");
			int kor = sc.nextInt();
			
			System.out.print("���� ����: ");
			int eng = sc.nextInt();
			
			System.out.print("���� ����: ");
			int mat = sc.nextInt();
			
			int tot = kor + eng + mat;
			
			double avg = tot / 3.0; // Ȥ�� double avg = (double)tot /3 
			
				System.out.printf("����: %3d\n", kor);
				System.out.printf("����: %3d\n", eng);
				System.out.printf("����: %3d\n", mat);
				System.out.printf("����: %d\t ���: %.2f\n",tot, avg);
		
		sc.close(); 
	}

}

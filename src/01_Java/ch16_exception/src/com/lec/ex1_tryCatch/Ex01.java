package com.lec.ex1_tryCatch;

import java.util.Scanner;

//�Ʒ��� ���� �����鿡�� ����ó�� �غ���. 

public class Ex01 {

// �Ʒ��� ���� �����鿡�� ����ó�� �غ���. 	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
		
			int i, j;
			
			System.out.print("ù��° ��: ");
			i = sc.nextInt();
			
			System.out.print("�ι�° ��: ");
			j = sc.nextInt();
			
			System.out.println("i = "+i+", j="+j);
			System.out.println("i * j = "+ (i*j));
			System.out.println("i / j = "+ (i/j));
			System.out.println("i + j = "+ (i+j));
			System.out.println("i - j = "+ (i-j));
			
			System.out.println("DONE");
			sc.close();
		}

}

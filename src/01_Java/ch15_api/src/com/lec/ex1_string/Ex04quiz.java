package com.lec.ex1_string;

import java.util.Scanner;

//I:checkIn("�ݳ��Ǿ����ϴ�" ���), O:checkOut("����Ǿ����ϴ�"���)
//x:����
public class Ex04quiz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String fn;
		
		while(true) {
			System.out.print("I:�ݳ� | O:���� | X:����");
			fn = sc.next();
			
			if(fn.equalsIgnoreCase("x")) { 
				break;
			}
			else if(fn.equalsIgnoreCase("i")) {
				System.out.println("�ݳ��Ǿ����ϴ�.");
			}
			else if(fn.equalsIgnoreCase("o")) {
				System.out.println("����Ǿ����ϴ�.");
				
			}
		}
//		do {
//			System.out.print("I:�ݳ� | O:���� | X:����");
//			fn = sc.next();
//			
//			if(fn.equalsIgnoreCase("i")) {
//				System.out.println("�ݳ��Ǿ����ϴ�.");
//			}
//			else if(fn.equalsIgnoreCase("o")) {
//				System.out.println("����Ǿ����ϴ�.");
//			}
//		}while(!fn.equalsIgnoreCase("x"));
	}
}


















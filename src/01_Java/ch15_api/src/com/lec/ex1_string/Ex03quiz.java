package com.lec.ex1_string;

import java.util.Scanner;

//com.lec.ex1_string.Ex03quiz->Ex03quiz
public class Ex03quiz {
	
		public static void main(String[] args) {
			
			Ex03quiz ex = new Ex03quiz();
			String fullname = ex.getClass().getName();
			String classname 
				= fullname.substring(fullname.lastIndexOf(".")+1);
			
			System.out.println(classname);
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("��ȭ��ȣ�� �Է��ϼ���(123-456-7890");
				String tel = sc.next();
				
				if(tel.equalsIgnoreCase("x")) break;
				System.out.println("�Է��� ��ȭ��ȣ: "+tel);
				System.out.print("¦����° ���ڿ�: ");
				
				for(int i=0 ; i<tel.length() ; i++) {
					if(i%2 == 0) {
						System.out.println(tel.charAt(i));
					}
					else {
						System.out.println(" ");
					}
				} // for
				System.out.println();
				System.out.print("���ڸ� �Ųٷ�");
				
				for(int i=tel.length()-1 ; i>=0 ; i++) {
					System.out.print(tel.charAt(i));
				}
				System.out.println();
				
				String pre = tel.substring(0, tel.indexOf("-"));
				String post = tel.substring(tel.lastIndexOf("-")+1);
				System.out.println("���� ���ڸ�: "+pre);
				System.out.println("���� ���ڸ�: "+post);
						
						
						
			}
		}

}














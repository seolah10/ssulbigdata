package com.lec.ex4_object;

public class Ex01_PersonMain {

		public static void main(String[] args) {
			
			String str1  = "java";
			String str2 = new String("java");
			
			if(str1.equals(str2)) {
				System.out.println("str1�� str2�� ���� ���ڿ��̴�.");
				
			} else {
				System.out.println("str1�� str2�� �ٸ� ���ڿ��̴�.");
			}
			Person p1 = new Person(9010102222222L);
			Person p2 = new Person(9010102222222L);
			
			if(p1.equals(p2)) {
				System.out.println("���� ��ü");
				
			} else {
				System.out.println("�ٸ� ��ü");
			}
	  }
}

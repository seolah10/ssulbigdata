package com.lec.loop;

// 1 + 2 + 3 + 4 + 5 + .... 19 + 20 = 210 
public class Ex02_for {
	
	public static void main(String[] args) {
		
		int tot = 0; // ������ ����
		for(int i=1 ; i<21 ; i++) {
			
			tot = tot +i;
			// tot ������ i���� ��� �����ϰ� "i + "�� "i = "�� ���
			
			if (i != 20) {
				System.out.print(i + " + ");
			}
			else {
				System.out.print(i + " + ");
			} // if 
		} // for
		System.out.println(tot);
	} // main
} // class


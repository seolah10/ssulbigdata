package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-1234-1234",
						 "010-2323-2323",
						 "010-3434-3434"};
		Scanner sc = new Scanner(System.in);
		int idx; // ��ȭ��ȣ�� �ߺ����� ���� ��
		
		System.out.println("ã������ ��ȭ��ȣ ���ڸ��� �Է��ϼ���: ");
		String searchTel = sc.next(); 
		
		for(idx=0 ; idx<tels.length ; idx++) {
				String temp = tels[idx];
				String post = temp.substring(temp.lastIndexOf("-")+1); // �Է��� ����ȭ�ϱ� ���� ���� ���� 
				if(searchTel.equals(post)) {
					System.out.println("��ü ��ȣ�� "+temp); //tels[idx]��� �ᵵ ����
					break;
				} // if 
		} // for
		if (idx == tels.length) {
				System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�.");
		}
	}
}

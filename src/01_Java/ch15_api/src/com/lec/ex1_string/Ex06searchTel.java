package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-1234-1234",
						 "010-2323-1234",
						 "010-3434-3434"};
		Scanner sc = new Scanner(System.in);
		
		boolean searchOk = false; // ��ȭ��ȣ ���ڸ��� �ߺ��Ǵ� ��찡 ���� ��
		System.out.println("ã������ ��ȭ��ȣ ���ڸ��� �Է��ϼ���.: ");
		String searchTel = sc.next();
		
		for(int idx=0 ; idx<tels.length ; idx++) { 
			String temp = tels[idx]; 
			String post = temp.substring(temp.lastIndexOf('-')+1);
			if(searchTel.equals(post)) { 
				System.out.println("��ü ��ȣ�� "+tels[idx]);
			}
		}
		if(!searchOk) { 
			System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�. ");
		}
	}
}

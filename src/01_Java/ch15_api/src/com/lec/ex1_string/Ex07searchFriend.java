package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� ģ�� ã��

public class Ex07searchFriend {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend ("������","010-1234-1234","12-14"),
							 new Friend ("����ȣ","010-3423-2323","10-14"),
							 new Friend ("������","010-3434-3434","11-12")};
		
		Scanner sc = new Scanner(System.in);
		//ã�� ģ���� ��ȭ��ȣ ���ڸ��� �Է¹޴´�.
		System.out.print("ã������ ģ���� ��ȭ��ȣ ���ڸ��� �Է��ϼ���. ");
		String searchTel = sc.next();
		int idx;
		boolean searchOk = false; 
		// friends �迭���� �ش� ��ȭ��ȣ ���ڸ��� ���� ģ���� ������ �� ģ���� ����ϰ�,
		// ������ ���ٰ� ����Ѵ�. 
		for(idx=0 ; idx<friends.length ; idx++) { 
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(post.equals(searchTel)) { 
				System.out.println(friends[idx]); // object�� toString
				// friends[idx].print();
				searchOk = true; // �ߺ��� �޹�ȣ�� ���� ���
				break; // �ߺ��� �޹�ȣ�� ���� ���
			}				
		}
		if(!searchOk) { 
			System.out.println("�ش��ȣ�� ģ���� �����ϴ�.");
		}
	}
}













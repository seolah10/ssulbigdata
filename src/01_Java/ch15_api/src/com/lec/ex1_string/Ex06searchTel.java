package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-1234-1234",
						 "010-2323-1234",
						 "010-3434-3434"};
		Scanner sc = new Scanner(System.in);
		
		boolean searchOk = false; // 전화번호 뒷자리가 중복되는 경우가 있을 때
		System.out.println("찾으려는 전화번호 뒷자리를 입력하세요.: ");
		String searchTel = sc.next();
		
		for(int idx=0 ; idx<tels.length ; idx++) { 
			String temp = tels[idx]; 
			String post = temp.substring(temp.lastIndexOf('-')+1);
			if(searchTel.equals(post)) { 
				System.out.println("전체 번호는 "+tels[idx]);
			}
		}
		if(!searchOk) { 
			System.out.println("입력하신 전화번호는 없는 번호입니다. ");
		}
	}
}

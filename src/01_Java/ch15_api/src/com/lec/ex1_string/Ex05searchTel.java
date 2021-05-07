package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-1234-1234",
						 "010-2323-2323",
						 "010-3434-3434"};
		Scanner sc = new Scanner(System.in);
		int idx; // 전화번호가 중복되지 않을 때
		
		System.out.println("찾으려는 전화번호 뒷자리를 입력하세요: ");
		String searchTel = sc.next(); 
		
		for(idx=0 ; idx<tels.length ; idx++) {
				String temp = tels[idx];
				String post = temp.substring(temp.lastIndexOf("-")+1); // 입력을 간소화하기 위한 변수 설정 
				if(searchTel.equals(post)) {
					System.out.println("전체 번호는 "+temp); //tels[idx]라고 써도 무방
					break;
				} // if 
		} // for
		if (idx == tels.length) {
				System.out.println("입력하신 전화번호는 없는 번호입니다.");
		}
	}
}

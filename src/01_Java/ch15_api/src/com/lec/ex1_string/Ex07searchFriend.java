package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 뒷자리로 친구 찾기

public class Ex07searchFriend {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend ("조정석","010-1234-1234","12-14"),
							 new Friend ("정경호","010-3423-2323","10-14"),
							 new Friend ("유연석","010-3434-3434","11-12")};
		
		Scanner sc = new Scanner(System.in);
		//찾을 친구의 전화번호 뒷자리를 입력받는다.
		System.out.print("찾으려는 친구의 전화번호 뒷자리를 입력하세요. ");
		String searchTel = sc.next();
		int idx;
		boolean searchOk = false; 
		// friends 배열에서 해당 전화번호 뒷자리와 같은 친구가 있으면 그 친구를 출력하고,
		// 없으면 없다고 출력한다. 
		for(idx=0 ; idx<friends.length ; idx++) { 
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(post.equals(searchTel)) { 
				System.out.println(friends[idx]); // object의 toString
				// friends[idx].print();
				searchOk = true; // 중복된 뒷번호가 있을 경우
				break; // 중복된 뒷번호가 없을 경우
			}				
		}
		if(!searchOk) { 
			System.out.println("해당번호의 친구가 없습니다.");
		}
	}
}













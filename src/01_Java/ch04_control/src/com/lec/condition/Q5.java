package com.lec.condition;

import java.util.Scanner;

// 현재 몇 월인지 키보드로 입력받아 계절을 출력하기
public class Q5 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		switch(month) { // swtich문으로 출력하기
		
			case 12: case 1: case 2:
				System.out.println("지금은 겨울입니다");
			
			case 3: case 4: case 5:
				System.out.println("지금은 봄입니다");
			
			case 6: case 7: case 8:
				System.out.println("지금은 여름입니다");
			
			case 9: case 10: case 11:
				System.out.println("지금은 가을입니다");
			
			default: 
				System.out.println("떼끼!");
		}
		
		if(month==12 || month==1 || month==2) { //if문으로 출력하기
			System.out.println("지금은 겨울입니다");
		}
		else if(month==3 || month==4 || month==5) {
			System.out.println("지금은 봄입니다");
		}
		else if(month==6 || month==7 || month==8) {
			System.out.println("지금은 여름입니다");
		}
		else if(month==9 || month==10 || month==11) {
			System.out.println("지금은 봄입니다");
		}
			System.out.println("떼끼");
	}
}























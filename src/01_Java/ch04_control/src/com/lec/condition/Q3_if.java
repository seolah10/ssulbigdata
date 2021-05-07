package com.lec.condition;

import java.util.Scanner;

// 사용자로부터 가위(0), 바위(1), 보(2) 중 하나를 입력받고,
// 컴퓨터도 가위(0), 바위(1), 보(2) 중 하나를 선택하여 승자를 출력하기
public class Q3_if {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위(0), 바위(1), 보(2)!!");
		int you = sc.nextInt();
		
		if (you==0) { 
			System.out.println("가위를 내셨군");
		}
		else if (you==1) {
			System.out.println("바위를 내셨군");
		}
		else if (you==2) { 
			System.out.println("보를 내셨군");
		}
		else {
			System.out.println("떼끼!");
			System.exit(0);
		}
		sc.close();
		
		int com = (int)(Math.random()*3);
		
		if(com==0) { 
			System.out.println("컴퓨터는 가위");
		}
		else if(com==1) {
			System.out.println("컴퓨터는 바위");
		}
		else {
			System.out.println("컴퓨터는 보");
		}
		
		if((you+2)%3 == com) { // 12.01 슬라이드 참고
			System.out.println("당신이 이겼어요!");
		}
		else if(you == com) {
			System.out.println("비겼네요");
		}
		else {
			System.out.println("아쉽네요~ 당신이 졌어요!");
		}

	 // 하나씩 대입해보는 방법
//		if(you==0) {
//			if (com==0) {
//				System.out.println("비겼네요");
//			}
//			else if (com==1) {
//				System.out.println("컴퓨터 승!");
//			}
//			else {
//				System.out.println("당신 승!");
//			}
//		}
//		else if (you==1) {
//			if (com==0) {
//				System.out.println("당신 승!");
//			}
//			else if (com==1) { 
//				System.out.println("비겼네요");
//			}
//			else {
//				System.out.println("컴퓨터 승!");
//			}
//		}
//		else if (you==2) { 
//			if (com==2) {
//				System.out.println("컴퓨터 승!");
//			}
//			else if (com==1) { 
//				System.out.println("당신 승!");
//			}
//			else {
//				System.out.println("비겼네요");
//			} // com if문
//		} // you if문
	} // main 함수

}// class




















































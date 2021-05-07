package com.lec.loop;

import java.util.Scanner;

// 컴퓨터와 가위(0) 바위(1) 보(2) 게임하기
public class Homework3 {
	
	public static void main(String[] args) {
		
		int com, you;
				Scanner sc = new Scanner(System.in);
		
		while(true) { 
				System.out.println("가위(0), 바위(1), 보(2)! (종료시 -1 입력)");
				you = sc.nextInt();
				
			if(you==-1) { 
					break;
			}

			com = (int)(Math.random()*3);

			if(you > 2 || you < -1) {
					System.out.println("다시 제대로 내세요");
			}
			else if((you+2)%3 == com) {
					System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
					System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보"));
					System.out.println("이기셨어요!");
			}
			else if(you == com) {
				System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
				System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보"));
				System.out.println("비겼네요~");
			}
			else {
				System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
				System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보"));
				System.out.println("지셨습니다");

			} // if문
		} // while문
		sc.close();
		System.out.println("bye");
	}

}

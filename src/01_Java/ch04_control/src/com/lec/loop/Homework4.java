package com.lec.loop;

import java.util.Scanner;

// 내가 이길 때까지 가위 바위 보 ! 
public class Homework4 {
	
	public static void main(String[] args) {
		
		int com, you;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("당신이 이길 때까지 가위(0), 바위(1), 보!(2)");
			you = sc.nextInt();
			com = (int)(Math.random()*3);
			
			if(you > 2  || you < -1) {
				System.out.println("다시 제대로 내세요");
			}
			else if ((you+2)%3 == com) { 
				System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
				System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보") );
				System.out.println("이기셨어요!");
			}
			else if (you == com) {
				System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
				System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보") );
				System.out.println("비겼어요");
			}
			else {
				System.out.println("당신은 "+(you==0 ? "가위" : you==1 ? "바위" : "보"));
				System.out.println("컴퓨터는 "+(com==0 ? "가위" : com==1 ? "바위" : "보") );
				System.out.println("지셨네요, 다시할까요?");
			} // if 
		}
		while( (you<0 || you>2) || ((you+1)%3 == com || you == com) );
		
		sc.close();
		System.out.println("bye!");
	}

}

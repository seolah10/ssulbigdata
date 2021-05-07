package com.lec.ex5_scanner;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		int com, you;
		String input;
		
		Scanner sc = new Scanner(System.in);
		
		do { 
				System.out.print("가위, 바위, 보 중 하나 선택(당신이 이길 때까지!): ");
				input = sc.nextLine().trim();
				com = (int)(Math.random()*3);
				
				if(input.equals("가위")) {
						you = 0;
						
				}else if(input.equals("바위")) {
						you = 1;
						
				}else if(input.equals("보")) {
						you = 2;
				
				}else {
						you = -1;
						continue;
						
				}
				if((you+2)%3 == com) {
					printResult(you, com);
					System.out.println("당신이 이겼어요");
				
				}else if(you == com) {
					printResult(you, com);
					System.out.println("비겼어요");
					
				}else {
					printResult (you, com);
					System.out.println("당신이 졌어요");
				}
			} while ((you<0 || you>2) || ((you+1)%3 == com || you == com));
		sc.close();
		System.out.println("bye!");
		}
		private static void printResult(int you, int com) {
			System.out.println("당신은 "+((you==0) ? "가위" : ((you==1) ? "바위" : "보")));
			System.out.println("컴퓨터는 "+((com==0) ? "가위" : ((com==1) ? "바위" : "보")));
		}
	
}

package com.lec.ex5_scanner;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		int com, you;
		String input;
		
		Scanner sc = new Scanner(System.in);
		
		do { 
				System.out.print("����, ����, �� �� �ϳ� ����(����� �̱� ������!): ");
				input = sc.nextLine().trim();
				com = (int)(Math.random()*3);
				
				if(input.equals("����")) {
						you = 0;
						
				}else if(input.equals("����")) {
						you = 1;
						
				}else if(input.equals("��")) {
						you = 2;
				
				}else {
						you = -1;
						continue;
						
				}
				if((you+2)%3 == com) {
					printResult(you, com);
					System.out.println("����� �̰���");
				
				}else if(you == com) {
					printResult(you, com);
					System.out.println("�����");
					
				}else {
					printResult (you, com);
					System.out.println("����� �����");
				}
			} while ((you<0 || you>2) || ((you+1)%3 == com || you == com));
		sc.close();
		System.out.println("bye!");
		}
		private static void printResult(int you, int com) {
			System.out.println("����� "+((you==0) ? "����" : ((you==1) ? "����" : "��")));
			System.out.println("��ǻ�ʹ� "+((com==0) ? "����" : ((com==1) ? "����" : "��")));
		}
	
}

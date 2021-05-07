package com.lec.loop;

import java.util.Scanner;

// 로또 번호 맞히기 프로그램2 

public class Ex10_doWhile_randomNum2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			int lotto = (int)(Math.random()*45)+1; 
			int num; // 사용자에게 입력받은 수를 저장하는 변수
			int min = 1;
			int max = 45;
			
		do {
					System.out.printf("%d부터 %d까지의 번호 중 하나를 입력하세요", min, max);
					num = sc.nextInt();
				
				if(num>lotto) { 
					System.out.println(num+"보다 작은 수를 입력하세요");
					max = num-1;
				}
				else if(num<lotto) { 
					System.out.println(num+"보다 큰 수를 입력하세요");
					min  = num+1;
				}

			}
			while(num!=lotto);
					
					System.out.println("축하합니다! 정답입니다.");
		}
	
	}


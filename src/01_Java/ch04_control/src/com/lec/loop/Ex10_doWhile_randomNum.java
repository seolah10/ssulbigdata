package com.lec.loop;

import java.util.Scanner;

// 로또 번호 알아맞히기 프로그램 생성

public class Ex10_doWhile_randomNum {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int lotto = (int)(Math.random()*45)+1; // 난수 생성  
		int num; // 사용자에게 입력받은 수를 저장하는 변수
		
		do {
				System.out.print("로또 번호 한 개를 알아맞춰 보세요.");
				num = sc.nextInt();
				
				if(num>lotto) { 
					System.out.println(num+"보다 작은 수를 입력하세요.");
				}
				else if(num<lotto) {
					System.out.println(num+"보다 큰 수를 입력하세요.");
				}
			
			} while (num!=lotto);
					
					System.out.println("맞추셨습니다!!");
		}
	
	}








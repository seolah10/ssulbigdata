package com.lec.condition;

import java.util.Scanner;

//점수를 입력받아 해당 점수에 해당하는 학점 출력하기
public class Q4_switch_grade {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		int temp = grade==100 ? grade-1 : grade; // 점수가 100점일 경우 적용하기 위한 변수
		
		switch(temp/10) {
		
		case 9 :
				System.out.println("A"); break;

		case 8 :
				System.out.println("A"); break;
		
		case 7 :
				System.out.println("A"); break;
		
		case 6 :
				System.out.println("A"); break;
		
		case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
				System.out.println("A"); break;
				
		default: 
				System.out.println("유효하지 않은 점수입니다");
		}
		sc.close();
	}

}

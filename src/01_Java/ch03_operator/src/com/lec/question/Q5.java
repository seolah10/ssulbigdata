package com.lec.question;

import java.util.Scanner;

// 국 영 수 총점 평균 구하기
public class Q5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.print("국어 점수: ");
			int kor = sc.nextInt();
			
			System.out.print("영어 점수: ");
			int eng = sc.nextInt();
			
			System.out.print("수학 점수: ");
			int mat = sc.nextInt();
			
			int tot = kor + eng + mat;
			
			double avg = tot / 3.0; // 혹은 double avg = (double)tot /3 
			
				System.out.printf("국어: %3d\n", kor);
				System.out.printf("영어: %3d\n", eng);
				System.out.printf("수학: %3d\n", mat);
				System.out.printf("총점: %d\t 평균: %.2f\n",tot, avg);
		
		sc.close(); 
	}

}

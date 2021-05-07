package com.lec.ex1_tryCatch;

import java.util.Scanner;

//아래를 뒤의 예제들에서 예외처리 해본다. 

public class Ex01 {

// 아래를 뒤의 예제들에서 예외처리 해본다. 	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
		
			int i, j;
			
			System.out.print("첫번째 수: ");
			i = sc.nextInt();
			
			System.out.print("두번째 수: ");
			j = sc.nextInt();
			
			System.out.println("i = "+i+", j="+j);
			System.out.println("i * j = "+ (i*j));
			System.out.println("i / j = "+ (i/j));
			System.out.println("i + j = "+ (i+j));
			System.out.println("i - j = "+ (i-j));
			
			System.out.println("DONE");
			sc.close();
		}

}

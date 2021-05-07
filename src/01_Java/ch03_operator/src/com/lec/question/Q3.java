package com.lec.question;

import java.util.Scanner;

// 입력한 두 수를 비교 연산자들을 이용하여 비교한 결과가 true면 O, false면 X를 출력하시오.
public class Q3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
				System.out.println("첫번째 수: ");
			int num1 = sc.nextInt();
			
				System.out.println("두번째 수: ");
			int num2 = sc.nextInt();
				
			String result = num1==num2 ? "0" : "X";
				System.out.println("num1 == num2 의 결과는 "+result);
			
			boolean result2 = num1 > num2;
				System.out.println("num1 > num2의 결과는 "+
								( (result2==true)? "O":"X") );
				
		sc.close();
					
	}

}

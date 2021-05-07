package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	
		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				
				int i, j = 1;
				
				do { 
					
					try {
							System.out.print("첫번째 수: "); // (수에 문자를 입력할 경우를 대비하여 예외처리)
							i = sc.nextInt(); // @\n
							break;
							
					} catch (InputMismatchException e) { // 수를 입력하지 않으면 나타나는 에러메시지 (Exception이라고 적어도 무방)
							System.out.println(e.getMessage());
							System.out.println("숫자만 입력하세요.");
							sc.nextLine(); // 버퍼 삭제
					}
					
				} while (true);	 // 다시 do로 올라간다.
				
				System.out.print("두번째 수: ");
				
				try { 	// 예외 발생시 catch로 바로 떨어져서, try안의 명령은 수행하지 않는다.
						j = sc.nextInt();
						
						System.out.println("i = "+i+", j = "
								+ ""+j);
						System.out.println("i * j = "+ (i*j));
						System.out.println("i / j = "+ (i/j));
						
				} catch (InputMismatchException e) {	// j값 초기화 필요
					
						System.out.println(e.getMessage());
						System.out.println("두번째 수를 잘못 입력하셔서 1로 초기화됩니다.");
						
				} catch (ArithmeticException e) {
						
						System.out.println(e.getMessage()+"0으로 나누ㅡㄴ 것은 패스");
				
				} catch (Exception e) { 	// catch가 2개 이상 있을 경우, 그냥 exception을 쓰려면 제일 아래에 있는 catch에 입력해야 한다.

						System.out.println(e.getMessage()+"무슨 에러일까?");
						
				}
				
				System.out.println("i + j = "+ (i+j));
				System.out.println("i - j = "+ (i-j));
				
				System.out.println("Done");
				sc.close();
		}

}







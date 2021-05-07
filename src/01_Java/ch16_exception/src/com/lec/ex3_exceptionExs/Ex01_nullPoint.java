package com.lec.ex3_exceptionExs;

// (없는 문자값에 명령을 실행할 경우, 이런 예외처리가 발생하나, 사실 이런경우는 거의없다.)

public class Ex01_nullPoint {
	
		public static void main(String[] args) {
			
				String greeting  = "Hello";
				System.out.println(greeting.toUpperCase());
				
				greeting = null;
				System.out.println(greeting.toUpperCase());
		}

}

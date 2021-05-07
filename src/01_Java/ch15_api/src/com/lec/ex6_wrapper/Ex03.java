package com.lec.ex6_wrapper;

// String -> Integer
// Integer -> String

public class Ex03 {
	
		public static void main(String[] args) {
				
				System.out.println("문자를 정수로: Integer.parseInt(문자열)");
				int i = Integer.parseInt("123");
				System.out.println(i);
				
				System.out.println("정수를 문자로: String.valueOf(정수)");
				//String monthString = ""+12;
				String monthString = String.valueOf(12);
				System.out.println(monthString);
		}
	


}

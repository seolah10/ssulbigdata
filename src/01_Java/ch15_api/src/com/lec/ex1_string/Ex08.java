package com.lec.ex1_string;

// str1 변수를 변경하기 전과 후의 결과를 비교해보자.

public class Ex08 {
	
	public static void main(String[] args) {
		
			String str1 = "월드컵";
			String str2 = "월드컵";
			
			if(str1==str2) { 
				System.out.println("str1과 str2는 같은 주소이다.");
			}
			else {
				System.out.println("str1과 str2는 다른 주소이다.");
			}
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode());

			
			str1 = str1.concat("2002"); // str1 = str1 + "2002";
			if(str1==str2) { 
				System.out.println("str1과 str2는 같은 주소이다.");
			}
			else {
				System.out.println("str1과 str2는 다른 주소이다.");
			}
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode());
			}
	}



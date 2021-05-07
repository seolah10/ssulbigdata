package com.lec.ex;

// 논리 연산자 (&&;and , ||;or)
public class Ex04 {
	
	public static void main(String[] args) {
	
		int i = 1,
			j = 10,
			h = 10;
		
				System.out.println("i>j || ++j>h는 "+
								 ((i>j) || (++j>h)) );
				System.out.println("j= "+j);
				
				System.out.println("i>j || ++j>h는 "+
						 ((i>j) || (++j>h)) );
				System.out.println("j= "+j);
	}

}

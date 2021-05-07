package com.lec.condition;
// 주사위 던지기
public class Ex04_switch {

	public static void main(String[] args) {
		
		int num = 2;
		
		switch(num) {
			
		case 1:
				System.out.println("주사위 1"); break; // break를 걸지 않으면 해당 값부터 아래까지 싹 다 출력된다.
	
		case 2:
				System.out.println("주사위 2"); break;
				
		case 3: 
				System.out.println("주사위 3"); break;
				
		default : 
				System.out.println("그 외"); break;
		}
	}
		
}

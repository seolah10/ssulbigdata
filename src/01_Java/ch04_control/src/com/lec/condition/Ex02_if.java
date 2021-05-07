package com.lec.condition;

public class Ex02_if {
	
	public static void main(String[] args) {
		
		int seoulLunchPrice = 8000;
		
		if(seoulLunchPrice > 7000) {
			System.out.println("서울 밥 값 비싸네");
		}
		else if(seoulLunchPrice >= 6000) {
			System.out.println("뭐 재료값 만큼 하네");
		}
		else if(seoulLunchPrice >= 4000) {
			System.out.println("서울 밥 값 괜찮네");
		}
		else {
			System.out.println("엇 식당 주인 괜찮을까?");
		}
	}

}

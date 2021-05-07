package com.lec.loop;

// 1~10 중 홀수들의 합을 출력하기
public class Q2 {
	
	public static void main(String[] args) {
		
		int sum = 0;
		
//		for(int i=1 ; i<11 ; i+=2) {
//			sum += 1;
//		}
		for(int i=1 ; i<11 ; i++) {
			if(i%2 == 1) { 
				sum += i; 
			}
		}
		System.out.println("1~10까지 중 홀수들의 합은 "+sum);
	}

}

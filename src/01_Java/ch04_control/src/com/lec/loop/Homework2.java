package com.lec.loop;

// 두 주사위의 합이 6인 모든 경우의 수 출력하기
public class Homework2 {
	
	public static void main(String[] args) {
		
		for(int i=1 ; i<=6 ; i++) {
			for(int j=1 ; j<=6 ; j++) {
				
				if (i + j == 6) { 
					System.out.println("(" + i + "," + j + ")");
					
				} // if 
			} // for-j 
		} // for-i
	}

}

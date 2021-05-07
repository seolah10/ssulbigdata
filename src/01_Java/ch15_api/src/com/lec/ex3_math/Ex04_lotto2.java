package com.lec.ex3_math;

import java.util.Random;

// 이제 로또 번호를 중복될 염려가 없도록 처리해보자.

public class Ex04_lotto2 {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] lotto = new int[6];
		
		for(int i=0 ; i<lotto.length ; i++) { 

			int temp = random.nextInt(45)+1;
			boolean ok = true;
			
				for(int j=0 ; j<i ; j++) { // 중복된 번호가 뽑힌 경우
					
					if(temp==lotto[j]) {
						i--;
						ok = false; 
						break; // for-j 반복문 빠져나감 
					} // if
				} // for - 중복확인
				if(ok) {
					lotto[i] = temp;
				}
			}
			for (int l : lotto) {
				System.out.print(l + "\t");
			}
		}
		
}



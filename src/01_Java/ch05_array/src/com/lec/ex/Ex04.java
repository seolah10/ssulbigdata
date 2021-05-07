package com.lec.ex;
// 다차원 배열 - PPT1202.5_배열 (슬라이드6-7 참고)
public class Ex04 {
	public static void main(String[] args) {
		int[][] test = { {10,20,30},
						 {40,50,60} };
		test[0][2] = 300;
		System.out.println(test[0][2]);
		System.out.println(test[1].length);
		for(int i=0 ; i<test.length ; i++) {
			for(int j=0 ; j<test[i].length ; j++) {
				System.out.printf("test[%d][%d] = %d\n",
										 i, j, test[i][j]);
			}
		}
	}
}


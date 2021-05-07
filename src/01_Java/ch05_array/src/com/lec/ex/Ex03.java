package com.lec.ex;
// 배열 복사 - PPT자료(1202.5_배열) 4번째 슬라이드 참고 
public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s= new int[score.length]; // score와 같은 양의 공간 확보 (데이터 구성은 안 들어감!)
//		for(int i=0 ; i<score.length ; i++) {
//			s[i] = score[i];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		s[0] = 999;
		for(int i=0; i<s.length ; i++) { 
			System.out.printf("s[%d]=%d, score[%d]=%d\n",
								  i, s[i], i, score[i]); 
		}
	}	
}

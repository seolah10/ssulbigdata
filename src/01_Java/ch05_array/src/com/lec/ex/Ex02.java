package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
// 		double[] hak = {4,5,3.3,3.0};
//		String[] names = {"È«±æµ¿","±è±æµ¿"};
		int [] s = score; 
		s[0] = 100;
		for(int idx=0 ; idx<score.length ; idx++) {
			System.out.printf("score[%d] = %d, s[%d]=%d\n", 
									idx, score[idx], idx, s[idx]); // s¸¦ ¹Ù²å´Âµ¥ score±îÁö ¹Ù²ï´Ù. 
		}
	}

}

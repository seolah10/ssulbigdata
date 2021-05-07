package com.lec.ex1_string;

// String과 StringBuffer, StringBuiler의 시간비교 

public class Ex10_speedChk {

	public static void main(String[] args) {
		// 1. String
		String str = "A";
		
		//시작시간 측정
		long start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			str = str.concat("a");
		}
		// 끝나는 시간 측정 
		long end = System.currentTimeMillis();
		System.out.println("String 변경 시간: "+(end-start));
		
		
		// 2. StringBuffer
		StringBuffer strBuff = new StringBuffer("A");
		
		// 시작시간 측정
		start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			strBuff.append("a");
		}
		//끝나는 시간 측정
		end = System.currentTimeMillis();
		System.out.println("StringBuff 변경 시간: "+(end-start));
		
		
		// 3. StringBuilder
		StringBuilder stringBuil = new StringBuilder("A");
		
		// 시작시간 측정
		start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			strBuff.append("a");
	}
		// 끝나는 시간 측정
		end = System.currentTimeMillis();
		System.out.println("StringBuilder 변경 시간: "+(end-start));
	}
}















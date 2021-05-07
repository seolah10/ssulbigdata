package com.lec.ex1_string;

import java.util.StringTokenizer;

// 슬라이드 참고

public class Ex11_stringToken {
	
	public static void main(String[] args) {
		
		String str1 = "정해인 유준상 강동원 김윤석 하정우"; //space 기준으로 토크나이징
		String str2 = "2020/12/14";				  //  / 기준으로 토크나이징
		
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2,"/");
		
		System.out.println("token1의 갯수: "+token1.countTokens());
		
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		System.out.println("token2의 갯수: "+token2.countTokens());
		
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
	}

}

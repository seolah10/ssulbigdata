package com.lec.ex1_string;

import java.util.StringTokenizer;

// Ex11의 str1 변수들을  토크나이징하여 배열로 넣어본다.

public class Ex12_tokenArray {

	public static void main(String[] args) {
		
		String str = "정해인 유준상 강동원 김윤석 하정우";
		
		String[] names; 
		// space, \t, \n => whitespace 
		StringTokenizer tokenizer = new StringTokenizer(str);
		
		names = new String[tokenizer.countTokens()];
		int idx=0;
		
		while(tokenizer.hasMoreElements()) { // hasmoreToken을 써도 됨
			names[idx++] = tokenizer.nextToken();
	}
		System.out.println("제대로 배열에 들어갔는지 확인");
		
		for(String name : names) { 
			System.out.println(name);
		}

	}
}
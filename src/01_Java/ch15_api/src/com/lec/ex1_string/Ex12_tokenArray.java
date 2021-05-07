package com.lec.ex1_string;

import java.util.StringTokenizer;

// Ex11�� str1 ��������  ��ũ����¡�Ͽ� �迭�� �־��.

public class Ex12_tokenArray {

	public static void main(String[] args) {
		
		String str = "������ ���ػ� ������ ������ ������";
		
		String[] names; 
		// space, \t, \n => whitespace 
		StringTokenizer tokenizer = new StringTokenizer(str);
		
		names = new String[tokenizer.countTokens()];
		int idx=0;
		
		while(tokenizer.hasMoreElements()) { // hasmoreToken�� �ᵵ ��
			names[idx++] = tokenizer.nextToken();
	}
		System.out.println("����� �迭�� ������ Ȯ��");
		
		for(String name : names) { 
			System.out.println(name);
		}

	}
}
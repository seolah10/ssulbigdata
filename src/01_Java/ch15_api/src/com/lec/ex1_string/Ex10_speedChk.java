package com.lec.ex1_string;

// String�� StringBuffer, StringBuiler�� �ð��� 

public class Ex10_speedChk {

	public static void main(String[] args) {
		// 1. String
		String str = "A";
		
		//���۽ð� ����
		long start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			str = str.concat("a");
		}
		// ������ �ð� ���� 
		long end = System.currentTimeMillis();
		System.out.println("String ���� �ð�: "+(end-start));
		
		
		// 2. StringBuffer
		StringBuffer strBuff = new StringBuffer("A");
		
		// ���۽ð� ����
		start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			strBuff.append("a");
		}
		//������ �ð� ����
		end = System.currentTimeMillis();
		System.out.println("StringBuff ���� �ð�: "+(end-start));
		
		
		// 3. StringBuilder
		StringBuilder stringBuil = new StringBuilder("A");
		
		// ���۽ð� ����
		start = System.currentTimeMillis();
		for(int i=0 ; i<200000 ; i++) {
			strBuff.append("a");
	}
		// ������ �ð� ����
		end = System.currentTimeMillis();
		System.out.println("StringBuilder ���� �ð�: "+(end-start));
	}
}















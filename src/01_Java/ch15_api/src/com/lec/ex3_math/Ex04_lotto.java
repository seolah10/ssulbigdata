package com.lec.ex3_math;

import java.util.Random;

// �Ʒ��� ���� �ϸ� �ߺ��� �ζ� ��ȣ�� �߻��� ���� �ִ�.

public class Ex04_lotto {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] lotto = new int[6];
		
		for(int i=0 ; i<lotto.length ; i++) {
			lotto[i] = random.nextInt(45);
		}
		for(int l : lotto) {
			System.out.print(l +"\t");
		}
	}

}

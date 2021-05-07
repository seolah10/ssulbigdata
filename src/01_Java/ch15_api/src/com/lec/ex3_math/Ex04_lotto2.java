package com.lec.ex3_math;

import java.util.Random;

// ���� �ζ� ��ȣ�� �ߺ��� ������ ������ ó���غ���.

public class Ex04_lotto2 {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] lotto = new int[6];
		
		for(int i=0 ; i<lotto.length ; i++) { 

			int temp = random.nextInt(45)+1;
			boolean ok = true;
			
				for(int j=0 ; j<i ; j++) { // �ߺ��� ��ȣ�� ���� ���
					
					if(temp==lotto[j]) {
						i--;
						ok = false; 
						break; // for-j �ݺ��� �������� 
					} // if
				} // for - �ߺ�Ȯ��
				if(ok) {
					lotto[i] = temp;
				}
			}
			for (int l : lotto) {
				System.out.print(l + "\t");
			}
		}
		
}



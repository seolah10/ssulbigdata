package com.lec.loop;

public class Ex05_forBreak {

	public static void main(String[] args) {
		
		for(int i=1 ; i<11 ; i++) {
			
			if(i==5) { 
					// break; �ݺ��� ���� ����������.
					continue; // ���������� �ö� (���⼭�� 5�� �ǳʶٰ� ��� ����) 
			}
			System.out.print(i+" ");
		}
	}

}

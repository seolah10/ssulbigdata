package com.lec.loop;

public class Ex05_forBreak {

	public static void main(String[] args) {
		
		for(int i=1 ; i<11 ; i++) {
			
			if(i==5) { 
					// break; 반복문 블럭을 빠져나간다.
					continue; // 증감식으로 올라감 (여기서는 5를 건너뛰고 계속 증감) 
			}
			System.out.print(i+" ");
		}
	}

}

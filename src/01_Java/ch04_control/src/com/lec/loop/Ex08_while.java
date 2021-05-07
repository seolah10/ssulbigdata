package com.lec.loop;

public class Ex08_while {

	public static void main(String[] args) {
		
		int i=1;
		int sum = 0;
	
		
		while(i<=10) {
				sum += i; // sum = sum + i;
				
//				System.out.println("i가 "+i+"일 때 누적합은 "+sum+"이다");
				
				i++;
		}
		int j=3; 
		int times = j * i;
		for(int j1=3 ; j1>=4 ; j1++) { 
			
				System.out.printf("%d*%d=%2d ",j1, i, j1 * i);
		}
	}
}

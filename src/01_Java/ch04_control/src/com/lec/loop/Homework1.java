package com.lec.loop;

// 1~20의 정수 중에서 2오 3의 배수가 아닌 수의 합

public class Homework1 {
	
	public static void main(String[] args) {
		
		int tot = 0;
		
		for(int i=1 ; i<=20 ; i++) { 
			
			if(i%2!=0 && i%3!=0) { 
				tot += i;
			}
		}
		System.out.println(tot);
	}

}

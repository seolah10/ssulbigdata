package com.lec.ex;

public class VarEx07 {

	public static void main(String[] args) {
		
		int i1 = 10; // 4byte
		long l1 = 2200000000L; 
		l1 = 10; 
			// 8byte인 long형에 4byte짜리 10을 할당하기 위해
			// 8byte(long형)로 묵시적인 형변환
		
		double d = i1; // 묵시적인 형변환
		d = 10.7;
		i1 = (int)d; // 명시적인 형 변환시에는 데이터 손실이 올 수도 있다.
			
			System.out.println("i1= "+i1);
		
	}
}

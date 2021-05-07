package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
//		int i = 10; // 변수 선언과 초기화 (변수 하나에는 원래 오직 한 값만 들어간다.)
		int[] iArr = {10,20,30,40,50}; // 1. 배열의 선언과 초기화
		iArr[1] = 200; // 배열은 index로 접근 (index:0~4)
		for (int idx=0 ; idx<5 ; idx++) { // 일반 for문
			System.out.println(iArr[idx]);
		}
		int[] iArr2 = new int[5]; // 2. 배열 변수 선언과 배열 메모리 공간 확보 (데이터 배열이 우선 0으로 확보되어 있음)
		iArr2[0] = 777; // (0번째 값만 777로 바꾼다)
		for(int idx=0 ; idx<iArr2.length ; idx++) { // 일반 for문 (숫자 5를 iArr2.length(배열의 길이)로 바꾸어 표현)
			System.out.println(idx+"번째값 : "+iArr2[idx]);
		}
		int[] iArr3;// 3. 배열 변수 선언 
		iArr3 = new int[5]; // 0 0 0 0 0
//		for(int idx=0 ; idx<iArr3.length ; idx++) { //일반 for문으로 값 변경
//		iArr3[idx] = idx+1;
		for(int temp : iArr3) { //확장 for문으로 값 변경
			temp = 10; //(배열이 아니라 배열을 카피한 temp에 10을 짛어넣음 -배열 값은 바뀌지 않는다)
			// 변수의 값을 바꿀 때는 확장 for문을 쓰면 안된다. 
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) { //일반 for문으로 값 변경 
			iArr[idx] = 10; 
		}
		for(int temp : iArr3 ) { // 확장 for문 
			System.out.println(temp);
		}
				
	}
}

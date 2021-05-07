package com.lec.ex1;

import com.lec.ex.Ex02Arithmetic; // Arithmetic이 다른 패키지에 있으면 에러가 난다. So, import를 해야 한다.

public class Ex {
	public static void main(String[] args) {
		Ex02Arithmetic ar = new Ex02Arithmetic();
			System.out.println("합은 "+ar.sum(20));
	}
}

package com.lec.ex;

import com.acom.ex.Emp;

public class TestMain {

	public static void main(String[] args) {
		
		Emp emp = new Emp(101); // a회사의 Emp파일 연결
		com.bcom.ex.Emp emp1 = new com.bcom.ex.Emp(); // b회사의 파일은 불러오지 않았으므로 
													  // 경로를 직접 입력해야 한다.
	}
}

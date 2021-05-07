package com.lec.ex01store;

// ch12.ex10store 패키지 내용들의 리턴 타입을 바꿔본다.

public interface HeadQuarterStore { // ch12에서 class였지만, 여기선 interface로 바꾼다.
	
	// 데이터, 생성자 삭제
	
	public void kimchi(); // 추상 메소드(abstract 생략)
	public void budae();
	public void bibim();
	public void sundae();
	public void gonggi();
	public String getName(); // 

	// getter 삭제 (위에 메소드로 대신 추가)
}
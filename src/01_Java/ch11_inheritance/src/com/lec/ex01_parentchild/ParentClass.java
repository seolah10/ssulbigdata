package com.lec.ex01_parentchild;

// 상속해주는 클래스: parent class(=super class, 부모 클래스)

public class ParentClass {
	
	String pStr = "부모 클래스";
	
	public ParentClass() { 
		System.out.println("부모 클래스 객체 부분 생성");
	}
	
	
	public void getPapaname() {
		System.out.println("아빠 이름: 홍길동");
	}
	public void getMamaname() {
		System.out.println("엄마 이름: 김길순");
	}

}

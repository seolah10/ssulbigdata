package com.lec.ex01_parentchild;

// 상속 받는 클래스: Child class (= 자손 클래스)

public class ChildClass extends ParentClass {
	
	String cStr = "자손 클래스";

	public ChildClass() {
		System.out.println("자손 클래스 객체 부분 생성");
	}
}

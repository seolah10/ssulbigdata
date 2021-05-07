package com.lec.ex10;

// 부모 클래스에 매개변수 없는 생성자가 없을 때

public class Child extends Parent {
	
	public Child(int i) {
		super(i); // 항상 매개변수가 있는 부모 클래스의 생성자를 호출한다.
	}

}

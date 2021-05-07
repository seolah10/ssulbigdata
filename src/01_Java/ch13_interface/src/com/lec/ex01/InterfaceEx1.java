package com.lec.ex01;

// interface에는 추상메소드와 상수만 올 수 있다.

public interface InterfaceEx1 {

			// 부분주석 : ctrl+shift+/ 
	public /* static final */ int CONSTANT_NUM = 10; // 당연히 상수만 가능해서 static final은 생략한다. 
	
	public /* abstract */ void method1(); // 마찬가지로 당연히 추상메소드만 가능해서 abstract은 생략한다.
}

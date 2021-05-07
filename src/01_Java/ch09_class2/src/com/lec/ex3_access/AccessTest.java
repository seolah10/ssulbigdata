package com.lec.ex3_access;
// 접근제한자
public class AccessTest {
	private int privateMember; // 같은 클래스 내에서만
	
	int defaultMember; // default: 같은 패키지에서만
	
	protected int protectedMember; // 같은 패키지나 상속받은 하위 클래스에서
	
	public int publicMember; // 어디서나 접근 가능
	
	
	private void privateMethod() { // 
			System.out.println("private method 호출");
	}
	void defaultMethod() {
			System.out.println("default method 호출");
	}
	protected void protectedMethod() {
			System.out.println("protected method 호출");
	}
	public void publicMethod() {
			System.out.println("public method 호출");
	}
}

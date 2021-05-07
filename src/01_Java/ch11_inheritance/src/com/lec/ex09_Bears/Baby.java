package com.lec.ex09_Bears;

// 곰 세마리 부르기 - 아기곰

public class Baby extends Person {
	
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); // 부모단의 생성자. 항상 첫 명령어로 호출되어야 한다.

		System.out.println("매개변수 있는 Baby 생성자");
	}
	
	public void cry() {
		System.out.println("응애응애");
	}
	
	@Override
	public void intro() {
		System.out.println(getName()+"은(는) 아기라서 엄마가 대신 소개할게");
		super.intro();
	}
}

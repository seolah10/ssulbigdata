package com.lec.ex07_super;

public class ChildClass extends ParentClass {
	
	private String c = "자식 클래스";
			
	public ChildClass() {
		System.out.println("자식 생성자");
	}
	
	@Override
	public void getMamaName() {
		// super() 부모 클래스 생성자 (반드시 맨 윗줄에 쓴다.)
		// super. 부모의 (아무 위치에나 사용할 수 있다.)
		System.out.println("이쁜 아주 이쁜");  
		super.getMamaName();
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
}

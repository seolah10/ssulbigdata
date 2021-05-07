package com.lec.ex01_store;

// 추상 클래스(abstract class) : 추상 메소드가 1개 이상 있는 클래스
// ch11.ex11store 패키지를 추상 메소드로 ... (내용도 약간 다름)

public abstract class HeadQuarterStore {

	private String name;
	
	public HeadQuarterStore(String name) { 
		this.name = name;
	}
	
	public abstract void kimchi(); // 추상 메소드
	public abstract void budae();
	public abstract void bibim();
	public abstract void sundae();
	public abstract void gonggi();
	
 	public String getName() {
 		return name;
 	}
}
package com.lec.ex01_store;

//김치찌개-5,000 부대찌개-5,000 비빔밥-5,000 순대국-5,000  공기밥-무료

public class StoreNum2 extends HeadQuarterStore {

	public StoreNum2(String name) {
		super(name);
	}
	// override(재정의); 부모 클래스의 메소드 재정의
	// overload(중복 정의); 매개변수의 수나 타입으로 같은 이름의 함수를 중복 정의
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	@Override
	public void budae() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void sundae() {
		System.out.println("순대국 5,000원");
	}
	@Override
	public void gonggi() {
		System.out.println("공기밥 무료!");
	}
}

package com.lec.ex01store;

//StoreNum1와 동일한 방식으로 수정

public class StoreNum3 implements HeadQuarterStore {
	
	private String name;
	
	public StoreNum3(String name) { 
		this.name = name;
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 6,000원");
	}
	@Override
	public void budae() {
		System.out.println("부대찌개 7,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 7,000원");
	}
	@Override
	public void sundae() {
		System.out.println("순대국 6,000원");
	}

	@Override
	public void gonggi() {
		System.out.println("공기밥 1,000원");
	}
	
	public String getName() {
		return name;
	}
}

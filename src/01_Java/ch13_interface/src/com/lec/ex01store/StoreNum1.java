package com.lec.ex01store;

//extends->implements name변수 추가, 생성자수정, getter추가

public class StoreNum1 implements HeadQuarterStore { ////extends->implements

	private String name; // 데이터 추가
	
	public StoreNum1(String name) { 
		this.name = name; // 생성자 수정
	}	
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 4,500원"); 
	}
	@Override
	public void budae() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 6,000원");
		
	}
	@Override
	public void sundae() {
		System.out.println("순대국 안팔아요");
	}
	@Override
	public void gonggi() {
		System.out.println("공기밥 1,000원");
		
	}
	public String getName() {
		return name; //getter 추가 
	}
}

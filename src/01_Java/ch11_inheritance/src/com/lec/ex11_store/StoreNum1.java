package com.lec.ex11_store;

//부대찌개-5,000, 순대국-안팔아   StoreNum1 store1 = new StoreNum1("주택가 1호점");

public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String name) { 
		super(name);
	}
	
	@Override
	public void budae() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sundae() {
		System.out.println("순대국 안 팔아");
	}
	
}

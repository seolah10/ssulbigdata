package com.lec.ex11_store;

//�δ��-5,000, ���뱹-���Ⱦ�   StoreNum1 store1 = new StoreNum1("���ð� 1ȣ��");

public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String name) { 
		super(name);
	}
	
	@Override
	public void budae() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹 �� �Ⱦ�");
	}
	
}

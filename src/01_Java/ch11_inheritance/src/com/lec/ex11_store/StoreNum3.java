package com.lec.ex11_store;

//��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000

public class StoreNum3 extends HeadQuarterStore {
	
	public StoreNum3(String name) { 
		super(name);
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}
	@Override
	public void budae() {
		System.out.println("�δ�� 7,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 7,000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹 6,000��");
	}
}

package com.lec.ex01store;

//StoreNum1�� ������ ������� ����

public class StoreNum3 implements HeadQuarterStore {
	
	private String name;
	
	public StoreNum3(String name) { 
		this.name = name;
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

	@Override
	public void gonggi() {
		System.out.println("����� 1,000��");
	}
	
	public String getName() {
		return name;
	}
}

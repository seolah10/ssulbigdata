package com.lec.ex01store;

// StoreNum1�� ������ ������� ����

public class StoreNum2 implements HeadQuarterStore {

	private String name;
	
	public StoreNum2(String name) {
		this.name = name;
	}
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}
	@Override
	public void budae() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹 5,000��");
	}
	@Override
	public void gonggi() {
		System.out.println("����� ����!");
	}
	public String getName() {
		return name;
	}
}

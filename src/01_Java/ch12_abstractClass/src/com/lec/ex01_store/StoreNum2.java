package com.lec.ex01_store;

//��ġ�-5,000 �δ��-5,000 �����-5,000 ���뱹-5,000  �����-����

public class StoreNum2 extends HeadQuarterStore {

	public StoreNum2(String name) {
		super(name);
	}
	// override(������); �θ� Ŭ������ �޼ҵ� ������
	// overload(�ߺ� ����); �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	
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
}

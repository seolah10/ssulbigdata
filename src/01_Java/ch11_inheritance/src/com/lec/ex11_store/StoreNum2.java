package com.lec.ex11_store;

//�δ��-5,000  �����-5,000 �����-����

public class StoreNum2 extends HeadQuarterStore {

	public StoreNum2(String name) {
		super(name);
	}
	// override(������); �θ� Ŭ������ �޼ҵ� ������
	// overload(�ߺ� ����); �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	
	@Override
	public void budae() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 5,000��");
	}
	@Override
	public void gonggi() {
		System.out.println("����� ����!");
	}
}

package com.lec.ex09_Bears;

// �� ������ �θ��� - �Ʊ��

public class Baby extends Person {
	
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		super(name, character); // �θ���� ������. �׻� ù ��ɾ�� ȣ��Ǿ�� �Ѵ�.

		System.out.println("�Ű����� �ִ� Baby ������");
	}
	
	public void cry() {
		System.out.println("��������");
	}
	
	@Override
	public void intro() {
		System.out.println(getName()+"��(��) �Ʊ�� ������ ��� �Ұ��Ұ�");
		super.intro();
	}
}

package com.lec.ex07_super;

public class ChildClass extends ParentClass {
	
	private String c = "�ڽ� Ŭ����";
			
	public ChildClass() {
		System.out.println("�ڽ� ������");
	}
	
	@Override
	public void getMamaName() {
		// super() �θ� Ŭ���� ������ (�ݵ�� �� ���ٿ� ����.)
		// super. �θ��� (�ƹ� ��ġ���� ����� �� �ִ�.)
		System.out.println("�̻� ���� �̻�");  
		super.getMamaName();
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
}

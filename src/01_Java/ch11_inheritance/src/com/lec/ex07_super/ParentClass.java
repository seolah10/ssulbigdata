package com.lec.ex07_super;

public class ParentClass {
	
	private String p = "�θ� Ŭ����";
	
	public ParentClass() {
		System.out.println("�θ� ������");
	}
	
	public void getPapaName() {
		System.out.println("�ƺ� ȫ�浿");
	
	}
	public void getMamaName() {
		System.out.println("���� �����");
	}
	
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}

}

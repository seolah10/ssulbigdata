package com.lec.ex01store;

//extends->implements name���� �߰�, �����ڼ���, getter�߰�

public class StoreNum1 implements HeadQuarterStore { ////extends->implements

	private String name; // ������ �߰�
	
	public StoreNum1(String name) { 
		this.name = name; // ������ ����
	}	
	
	@Override
	public void kimchi() {
		System.out.println("��ġ� 4,500��"); 
	}
	@Override
	public void budae() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� 6,000��");
		
	}
	@Override
	public void sundae() {
		System.out.println("���뱹 ���Ⱦƿ�");
	}
	@Override
	public void gonggi() {
		System.out.println("����� 1,000��");
		
	}
	public String getName() {
		return name; //getter �߰� 
	}
}

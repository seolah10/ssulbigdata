package com.lec.ex11_store;

import javax.print.DocFlavor.STRING;

//��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��

public class HeadQuarterStore {

	private String name;
	
	public HeadQuarterStore(String name) { 
		this.name = name;
	}
	
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}
	public void budae() {
		System.out.println("�δ�� 6,000��");
	}
	public void bibim() {
		System.out.println("����� 6,000��");
	}
	public void sundae() {
		System.out.println("���뱹 5,000��");
	}
	public void gonggi() {
		System.out.println("����� 1,000��");
	}
	
	public String getName() {
		return name;
	}
}

package com.lec.ex06_this;

public class Friend {

	private String name;
	private String tel;
	
	public Friend() {
		System.out.println("�Ű����� 0�� ¥��");
	}
	public Friend(String name) {
		// this. :�� ��ü��
		// this(): �� Ŭ������ ������ �Լ�
		this();
		this.name = name;
		
		System.out.println("�Ű����� 1�� ¥��");
	}
	
	public Friend(String name, String tel) {
		this(name); // this.name = name;
		this.tel = tel;
	}
}

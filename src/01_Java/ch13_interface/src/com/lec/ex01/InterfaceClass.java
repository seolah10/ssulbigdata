package com.lec.ex01;

//InterfaceEx1 (CONSTANT_NUM, method1())
//InterfaceEx2 (CONSTANT_STRING, method2())

public class InterfaceClass implements InterfaceEx1, InterfaceEx2 { // �������̽��� ���߻���� �����ϴ�. 


	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�.");

	}
	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�.");
		return null; // null�� ��� ��ü Ÿ�Կ� �� ����. (�ƹ� �ǹ� ���� �Ŷ�� �����ϸ� ��)
	}
}

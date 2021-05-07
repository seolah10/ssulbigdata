package com.lec.ex3_access;
// ����������
public class AccessTest {
	private int privateMember; // ���� Ŭ���� ��������
	
	int defaultMember; // default: ���� ��Ű��������
	
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� ���� Ŭ��������
	
	public int publicMember; // ��𼭳� ���� ����
	
	
	private void privateMethod() { // 
			System.out.println("private method ȣ��");
	}
	void defaultMethod() {
			System.out.println("default method ȣ��");
	}
	protected void protectedMethod() {
			System.out.println("protected method ȣ��");
	}
	public void publicMethod() {
			System.out.println("public method ȣ��");
	}
}

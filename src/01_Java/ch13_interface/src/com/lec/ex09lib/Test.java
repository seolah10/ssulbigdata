package com.lec.ex09lib;

public class Test {

	public static void main(String[] args) {
		
		Book book1 = new Book("890��","�ڹ�","ȫ�浿");
		Book book2 = new Book("890��","�ϵ�","ȫ����");
		
		book1.checkIn(); // ������
		book1.checkOut("�ű浿", "201209"); // ����ó��
		book1.checkOut("��浿", "201209"); // ������
		
		book1.printState();
		book1.printState();
	}
}

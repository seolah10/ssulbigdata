package com.lec.ex09_Bears;

public class TestMain {
	
	public static void main(String[] args) {
		

	Person papa = new Person("�ƺ���","�׶���");
	Person mama = new Person("������","������");
	
	papa.intro();
	mama.intro();
	
		System.out.println("==================")
		;
	
	Baby child1 = new Baby(); 
	
	child1.setName("�Ʊ��1");
	child1.setCharacter("��, �� �Ϳ���");
	child1.intro();
	
	Baby child2 = new Baby("�Ʊ��2","�Ϳ���");
	child2.cry();
	child2.intro(); // �̰� ���� �׳� �ẽ 
	
	}
}

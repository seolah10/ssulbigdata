package com.lex.ex13_final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		animal.running();
		animal.running(); // �ݺ��� ���� 5�� ���ǵ� ����
		animal.stop();
		
		Dog dog = new Dog();
		
		dog.running();
		dog.stop();
		dog.method(); 
		
		
		Animal dog2 = new Dog();
		
		dog2.running();
		dog2.stop();
//		dog2.method(); �Ұ����Ѱ���

		
		Rabbit rabbit = new Rabbit();
		
		rabbit.running();
		rabbit.stop();
	}

}

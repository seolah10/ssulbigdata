package com.lex.ex13_final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		animal.running();
		animal.running(); // 반복할 수록 5씩 스피드 증가
		animal.stop();
		
		Dog dog = new Dog();
		
		dog.running();
		dog.stop();
		dog.method(); 
		
		
		Animal dog2 = new Dog();
		
		dog2.running();
		dog2.stop();
//		dog2.method(); 불가능한가봄

		
		Rabbit rabbit = new Rabbit();
		
		rabbit.running();
		rabbit.stop();
	}

}

package com.lec.ex13_final;

public class Rabbit extends Animal {
	public void running() {
		speed += 30;
		System.out.println("토끼가 마구 뛰어요. 현재 속도: " + speed);
	}
}

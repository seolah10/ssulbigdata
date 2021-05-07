package com.lec.ex04;

public class TestClass implements I3 { // I3의 자손 인터페이스인 I2, I3도 포함된다.

	@Override
	public void m1() {
		System.out.println("상수 i1: "+ i1);
		// TODO Auto-generated method stub

	}

	@Override
	public void m2() {
		System.out.println("상수 i2: "+ i2);
		// TODO Auto-generated method stub

	}

	@Override
	public void m3() {
		System.out.println("상수 i3: "+ i3);
		// TODO Auto-generated method stub

	}

}

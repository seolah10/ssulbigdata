package com.lec.ex06toy;

public class Pooh implements IMoveArmLeg {
	
	public Pooh() {
		System.out.println("������ Ǫ �Դϴ�.");
		canMoveArmLeg();canMoveArmLeg();
		System.out.println("=====================");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		return "�ȴٸ� �����̴� ������ Ǫ";
	}

}

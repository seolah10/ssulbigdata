package com.lec.ex06toy;

public class MazingerToy implements IMissile, IMoveArmLeg {
	
	public MazingerToy() {
		System.out.println("��¡�� �Դϴ�. ");
		canMissile();
		canMoveArmLeg();
		System.out.println("=====================");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "�̻��� ��� �ȴٸ� �����̴� ��¡�� �峭��";
	}
	
}

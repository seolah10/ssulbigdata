package com.lec.ex06toy;

public class AirplaneToy implements IMissile, ILight {
	
	public AirplaneToy() {
		System.out.println("�峭�� ����⿡��.");
		canLight();
		canMissile();
		System.out.println("=====================");
	}

	@Override
	public void canLight() {
		System.out.println("�Һ� �߻� �����ؿ�");
		
	}

	@Override
	public void canMissile() {
		System.out.println("�̻��ϵ� �� �� �ֽ��ϴ�.");
		
	}
	@Override
	public String toString() {
		return "�Һ��� �̻��� ������ �峭�� �����";
	}
	

}

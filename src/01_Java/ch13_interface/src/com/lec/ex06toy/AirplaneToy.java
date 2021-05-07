package com.lec.ex06toy;

public class AirplaneToy implements IMissile, ILight {
	
	public AirplaneToy() {
		System.out.println("장난감 비행기에요.");
		canLight();
		canMissile();
		System.out.println("=====================");
	}

	@Override
	public void canLight() {
		System.out.println("불빛 발사 가능해요");
		
	}

	@Override
	public void canMissile() {
		System.out.println("미사일도 쏠 수 있습니다.");
		
	}
	@Override
	public String toString() {
		return "불빛과 미사일 나가는 장난감 비행기";
	}
	

}

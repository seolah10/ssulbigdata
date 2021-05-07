package com.lec.ex06toy;

public class MazingerToy implements IMissile, IMoveArmLeg {
	
	public MazingerToy() {
		System.out.println("마징가 입니다. ");
		canMissile();
		canMoveArmLeg();
		System.out.println("=====================");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다.");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "미사일 쏘고 팔다리 움직이는 마징가 장난감";
	}
	
}

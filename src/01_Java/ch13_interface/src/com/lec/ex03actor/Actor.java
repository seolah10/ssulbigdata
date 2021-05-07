package com.lec.ex03actor;

public class Actor implements PoliceMan, FireFighter, Chef { // 배우 하정우의 역할들 다중 구현

	private String name;
	
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public void makePizza() {
		System.out.println(name+"피자를 만들 줄 알아요");
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"는 스파게티도 만들 줄 알아요.");
		// TODO Auto-generated method stub

	}

	@Override
	public void outFire() {
		System.out.println(name+"는 불을 끌 수 있어요");
		// TODO Auto-generated method stub

	}
	@Override
	public void saveMan() {
		System.out.println("그리고 "+name+"는 불 속에서 사람들을 구해내죠.");
		// TODO Auto-generated method stub

	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name+"는 범인을 잘 잡아요");
		// TODO Auto-generated method stub

	}

	@Override
	public void canSearch() {
		System.out.println(name+"는 물건도 찾아줘요");
		// TODO Auto-generated method stub

	}

}

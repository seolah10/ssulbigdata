package com.lec.ex06lunch;

public class Child2 extends LunchMenu {

	public Child2(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
	}

	@Override // 우유를 마실 수 있는 아이들의 식비 계산
	public int calculate() {
		return getRice() + getBulgogi() + 
			   getSoup() + getMilk(); 
				   
	}
}

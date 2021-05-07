package com.lec.ex03actor;

// 다중 구현을 이용한 다형성 

public class TestMain {

	public static void main(String[] args) {
		
		Actor ha = new Actor("하정우");
				
		ha.canCatchCriminal();
		ha.canSearch();
		ha.outFire();
		
		
		ha.saveMan();
		ha.makePizza();
		ha.makeSpaghetti();
		
		FireFighter fireha = ha;
		
		fireha.outFire();
		fireha.saveMan();
		
		
		PoliceMan policeha = ha;
		
		policeha.canCatchCriminal();
		policeha.canSearch();
		
		
		Chef chefha = ha;
		
		chefha.makePizza();
		chefha.makeSpaghetti();

	}

}

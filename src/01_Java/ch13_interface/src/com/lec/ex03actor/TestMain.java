package com.lec.ex03actor;

// ���� ������ �̿��� ������ 

public class TestMain {

	public static void main(String[] args) {
		
		Actor ha = new Actor("������");
				
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

package com.lec.ex02phone;

// A model: DMB송수신불가, 5G, TV리모콘 미탑재

public class AModel implements IAcor {

	private String modelName;
	
	public AModel() {
		modelName = "A model";
	}
	
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 불가");
	}

	@Override
	public void Ite() {
		System.out.println(modelName+"은 5G");
		// TODO Auto-generated method stub
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV리모콘 미탑재");
		// TODO Auto-generated method stub
		
	}

}

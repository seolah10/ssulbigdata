package com.lec.ex02phone;

//C회사: DMB송수신가능, LTE, TV리모콘 미탑재 

public class CModel implements IAcor {
	
	private String modelName;
	
	public CModel() {
		modelName = "C model";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 가능");
		// TODO Auto-generated method stub
	}
	@Override
	public void Ite() {
		System.out.println(modelName+"은 LTE");
		// TODO Auto-generated method stub

	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV리모컨 미탑재");
		// TODO Auto-generated method stub

	}

}

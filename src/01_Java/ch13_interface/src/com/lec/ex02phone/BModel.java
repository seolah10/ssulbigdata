package com.lec.ex02phone;

//b��ǰ : DMB�ۼ��Ű���, LTE, TV������ ž��

public class BModel implements IAcor {
	
	private String modelName;
	
	public BModel() {
		 modelName = "B model";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName+"�� DMB �ۼ��� ����");
		// TODO Auto-generated method stub

	}
	@Override
	public void Ite() {
		System.out.println(modelName+"�� LTE");
		// TODO Auto-generated method stub

	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"�� TV������ ž��");
		// TODO Auto-generated method stub

	}

}

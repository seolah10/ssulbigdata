package com.lec.ex02phone;

//Cȸ��: DMB�ۼ��Ű���, LTE, TV������ ��ž�� 

public class CModel implements IAcor {
	
	private String modelName;
	
	public CModel() {
		modelName = "C model";
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
		System.out.println(modelName+"�� TV������ ��ž��");
		// TODO Auto-generated method stub

	}

}

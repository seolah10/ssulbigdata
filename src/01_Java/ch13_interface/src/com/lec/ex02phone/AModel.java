package com.lec.ex02phone;

// A model: DMB�ۼ��źҰ�, 5G, TV������ ��ž��

public class AModel implements IAcor {

	private String modelName;
	
	public AModel() {
		modelName = "A model";
	}
	
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"�� DMB �ۼ��� �Ұ�");
	}

	@Override
	public void Ite() {
		System.out.println(modelName+"�� 5G");
		// TODO Auto-generated method stub
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"�� TV������ ��ž��");
		// TODO Auto-generated method stub
		
	}

}

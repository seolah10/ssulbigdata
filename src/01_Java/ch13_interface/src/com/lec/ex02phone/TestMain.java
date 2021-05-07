package com.lec.ex02phone;

public class TestMain {

	public static void main(String[] args) {
		
		AModel aPhone = new AModel();
		BModel bPhone = new BModel();
		CModel cPhone = new CModel();
		
		IAcor[] phones = {aPhone, bPhone, cPhone};
		
		for(IAcor phone : phones) {
			// ��ü�� Ŭ���� Ÿ��
			System.out.println(phone.getClass().getName()); //getClass�� getName�� Object���� �ҷ���
			
			phone.dmbReceive();
			phone.Ite();
			phone.tvRemoteControl();
		
		}
		

	}

}

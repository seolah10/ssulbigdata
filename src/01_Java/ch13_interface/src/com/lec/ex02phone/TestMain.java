package com.lec.ex02phone;

public class TestMain {

	public static void main(String[] args) {
		
		AModel aPhone = new AModel();
		BModel bPhone = new BModel();
		CModel cPhone = new CModel();
		
		IAcor[] phones = {aPhone, bPhone, cPhone};
		
		for(IAcor phone : phones) {
			// 객체의 클래스 타입
			System.out.println(phone.getClass().getName()); //getClass와 getName은 Object에서 불러옴
			
			phone.dmbReceive();
			phone.Ite();
			phone.tvRemoteControl();
		
		}
		

	}

}

package com.lec.ex07car;

//LowGradeCar lowCar = new LowGradeCar("red","±¤Æø",2000,"ÆÄ¿öÇÚµé");

import com.lec.cons.CarSpecEx07;

public class TestMain {

	public static void main(String[] args) {
		
		Car lowCar = new LowGradeCar(CarSpecEx07.GRAY_CAR,
									 CarSpecEx07.TIRE_NORMAL,
									 CarSpecEx07.DISPLACEMENT_1000,
									 CarSpecEx07.HANDLE_POWER);
		
		Car highCar = new HighGradeCar(CarSpecEx07.WHITE_CAR,
									   CarSpecEx07.TIRE_WIDE,
									   CarSpecEx07.DISPLACEMENT_2000,
									   CarSpecEx07.HANDLE_POWER);
		
		
		lowCar.getSpec();
		highCar.getSpec();
				
	}
}

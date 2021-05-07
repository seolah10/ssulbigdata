package com.lec.ex07car;

//LowGradeCar lowCar = new LowGradeCar("red","광폭",2000,"파워핸들");

public abstract class Car {
	
	private String color; 
	private String tire;
	private int displacement; // 배기량
	private String handle;
	
	
	public Car(String color, String tire, int displacement, String handle) {
		
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public abstract void getSpec(); // 추상 메소드로 차의 스펙 선언

	public String getColor() { // setter는 필요하지 않아 생략한다.
		return color;
	}

	public String getTire() {
		return tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public String getHandle() {
		return handle;
	}
	
	
	

}

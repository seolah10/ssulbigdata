package com.lec.ex07car;

//LowGradeCar lowCar = new LowGradeCar("red","����",2000,"�Ŀ��ڵ�");

public abstract class Car {
	
	private String color; 
	private String tire;
	private int displacement; // ��ⷮ
	private String handle;
	
	
	public Car(String color, String tire, int displacement, String handle) {
		
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public abstract void getSpec(); // �߻� �޼ҵ�� ���� ���� ����

	public String getColor() { // setter�� �ʿ����� �ʾ� �����Ѵ�.
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

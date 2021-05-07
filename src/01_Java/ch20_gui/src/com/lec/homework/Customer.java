package com.lec.homework;

public class Customer {
	private String phone;
	private String name;
	private int point;

	public Customer(String phone, String name, int point) {
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	@Override
	public String toString() {
		return name + "(" + phone + "): " + point; 
	}
	
	public String getPhone() {
		return phone;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}		
}
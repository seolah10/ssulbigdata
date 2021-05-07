package com.lec.ex2_parking;

import com.lec.comsForEx02.PiClass;

// Parking class ���� (����ȣ, �����ð�, �����ð�, �������)
public class Parking { // <������>
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private final int HOURLYRATE = 2000; ����� �ݵ�� �������� �빮�ڷ�! 
	
	public Parking(String no, int inTime) { // <������>
		this.no = no; 
		this.inTime = inTime;

		System.out.println(no+"�� ��似��");
		System.out.println("�����ð�: "+inTime+"��");
		System.out.println("*************************");
	}
	public void out (int outTime) { // <�޼ҵ�>
		this.outTime = outTime;
		fee = (outTime-inTime) * PiClass.HOURLYRATE; // (cons package�� PiClass.java ����)
	
		System.out.println(no+"�� �ȳ��� ������");
		System.out.println("�����ð�: "+inTime+"��");
		System.out.println("�����ð�: "+outTime+"��");
		System.out.println("�������: "+fee+"��");
		System.out.println("*************************");
	}
	// <setter & getter>
	public void setNo(String no) {
		this.no = no;
	}
	public String getNo() {
		return no;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getInTime() {
		return inTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getFee() {
		return fee;
	}
}
	

























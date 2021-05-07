package com.lec.ex2_parking;

import com.lec.comsForEx02.PiClass;

// Parking class 설계 (차번호, 입차시간, 출차시간, 주차요금)
public class Parking { // <데이터>
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private final int HOURLYRATE = 2000; 상수는 반드시 변수명을 대문자로! 
	
	public Parking(String no, int inTime) { // <생성자>
		this.no = no; 
		this.inTime = inTime;

		System.out.println(no+"님 어서요세요");
		System.out.println("입차시간: "+inTime+"시");
		System.out.println("*************************");
	}
	public void out (int outTime) { // <메소드>
		this.outTime = outTime;
		fee = (outTime-inTime) * PiClass.HOURLYRATE; // (cons package에 PiClass.java 참고)
	
		System.out.println(no+"님 안녕히 가세요");
		System.out.println("입차시간: "+inTime+"시");
		System.out.println("출차시간: "+outTime+"시");
		System.out.println("주차요금: "+fee+"원");
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
	

























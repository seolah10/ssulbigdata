package com.lec.ex09lib;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NORMAL = 0; // 대출 가능
	
	public void checkOut(String borrower, String checkOutDate); 
	public void checkIn(); // 반납
	public void printState(); // ex) "자바" 홍길동 저 대출가능 

}

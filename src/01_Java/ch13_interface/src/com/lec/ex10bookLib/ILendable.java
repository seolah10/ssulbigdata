package com.lec.ex10bookLib;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NORMAL = 0; // 대출 가능
	
	public void checkOut(String borrower, String checOutDate); // 대출
	public void checkIn(); // 반납
	public void printState(); // 도서 정보와 현재 상태 

}

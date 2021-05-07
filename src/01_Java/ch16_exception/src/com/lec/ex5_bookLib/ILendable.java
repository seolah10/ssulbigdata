package com.lec.ex5_bookLib;

public interface ILendable {
	
		public byte STATE_BORROWED = 1; // 대출중
		public byte STATE_NORMAL = 0; // 대출 가능
		
		public void checkOut(String borrower) throws Exception; // 대출
		public void checkIn() throws Exception; // 반납

}

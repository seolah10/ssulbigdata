package com.lec.ex5_bookLib;

public interface ILendable {
	
		public byte STATE_BORROWED = 1; // ������
		public byte STATE_NORMAL = 0; // ���� ����
		
		public void checkOut(String borrower) throws Exception; // ����
		public void checkIn() throws Exception; // �ݳ�

}

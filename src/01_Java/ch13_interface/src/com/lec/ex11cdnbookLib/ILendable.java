package com.lec.ex11cdnbookLib;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; // ���� ����
	
	public void checkOut(String borrower, String checkoutDate); // ����
	public void checkIn(); // �ݳ�
	public void printState(); // ���� ������ ����

}

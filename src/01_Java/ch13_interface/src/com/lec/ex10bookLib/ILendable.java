package com.lec.ex10bookLib;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; // ���� ����
	
	public void checkOut(String borrower, String checOutDate); // ����
	public void checkIn(); // �ݳ�
	public void printState(); // ���� ������ ���� ���� 

}

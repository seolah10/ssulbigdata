package com.lec.ex09lib;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; // ���� ����
	
	public void checkOut(String borrower, String checkOutDate); 
	public void checkIn(); // �ݳ�
	public void printState(); // ex) "�ڹ�" ȫ�浿 �� ���Ⱑ�� 

}

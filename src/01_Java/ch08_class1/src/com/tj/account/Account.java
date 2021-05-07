package com.tj.account;

/* ���� ���� Ŭ���� 
*	������ : ���¹�ȣ (accountmNo:String)
*		     ������    (ownerName:String)
*		     �ܾ�	 (balance:int)
*	�޼ҵ� : �����Ѵ� (void deposit(int money)) new Account("110-352","ȫ",10)
*		     �����ϴ� (int withdraw(int money)) new Account("110-352","ȫ")
*/
public class Account { // ������
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {} // ����Ʈ ������

	public Account(String accountNo, String ownerName) { // (������ �̸��� �ݵ�� Ŭ������� �����ϰ�!!)
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) { 
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(int money) {	// ������ ������
		balance += money; 
	}
	public void withdraw (int money) { // �ܾ� ������ "����" ���
		if(balance >= money) {
			balance -= money; // balance = balance - money;
		}else { 
			System.out.println("�ܾ� ����, ����");
		}
	}
	public void info() { // �޼ҵ�
		System.out.println("���¹�ȣ: "+accountNo+", "+ownerName+
						"�� �ܾ���"+balance);
	}
	// accountNo, ownerName, balance setter & getter
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo; 
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setOwnerName(String ownerName ) {
		this.ownerName = ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
}





























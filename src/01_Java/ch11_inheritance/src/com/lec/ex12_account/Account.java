package com.lec.ex12_account;
/* �������Ŭ����
 *  ������ : ���¹�ȣ (accountNo:String)
 *         ������   (ownerName:String) 
 *         �ܾ�      (balance:int)
 *  �޼ҵ� : �����Ѵ� (void deposit(int money))new Account("110-352","ȫ",10)
 *         �����ϴ� (void withdraw(int money))new Account("110-352","ȫ")
 */
public class Account {
	
	private String accountNo;
	private String ownerName;
	private int balance;
	
	
	public Account() {}
		
	public Account(String accountNo, String ownerName) {
	
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
	
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int money) { //������ ������
		balance += money;
	}
	public void withdraw(int money) {
		if(balance >= money) {
			balance -= money; // balance = balance - money;
		}
		else {
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}
	public void printAccount() {
		System.out.println("���¹�ȣ: "+accountNo+", "+ownerName+"���� �ܾ��� "+balance);
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}

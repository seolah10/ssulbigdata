package com.lec.ex12_account;

public class CheckingAccount extends Account {

	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	
	// CheckingAccount kim = new CheckingAccount("12","홍",20,"1111~");
	// kim.pay("1111~",10);
	
	public void pay(String cardNo, int amount) {
		
		if(this.cardNo.equals(cardNo)) {
			
			if(getBalance()<amount) {
				System.out.println("잔액이 부족합니다!");
			
			}else {
				setBalance(getBalance()-amount);
				System.out.println(amount+"사용되어 "+getBalance()+"남았습니다.");
			}
		
		}else {
			System.out.println("카드번호가 올바르지 않습니다.");
		}
	
	
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}

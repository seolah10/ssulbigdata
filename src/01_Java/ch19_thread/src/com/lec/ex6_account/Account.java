package com.lec.ex6_account;


public class Account {
	
		private int balance; 
		
		public Account() { }
		
		public Account(int balance) {
				this.balance = balance;
		}
		
		public synchronized void deposit(int amount, String who) {
				System.out.println(who+"�� �Ա� ���� ~ ~ ~");
				System.out.println("�Ա� �� �ܾ�: "+balance);
				balance += amount; 
				System.out.println(amount+"�� �Ա� �� �ܾ�: "+balance);
				System.out.println(who+"�� �Ա� �� ~ ~ ~");
		}
		public synchronized void withdraw(int amount, String who) {
				System.out.println(who+"�� ��� ���� ~ ~ ~");
				System.out.println("��� �� �ܾ�: "+balance);
				
				if(balance < amount) {
						System.out.println("�ܾ� �������� ��� �Ұ�");
						
				} else {
						balance -= amount;
						System.out.println("��� �� �ܾ�: "+balance);
				}
				System.out.println(who+"��(��) ��� �� ~ ~ ~");
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}

}

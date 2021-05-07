package com.lec.ex4_account;

public class Account {

		private String accountNo;
		private String ownerName;
		private int balance;
		
		public Account() { }

		public Account(String accountNo, String ownerName) {
			this.accountNo = accountNo;
			this.ownerName = ownerName;
		}
		public Account(String accountNo, String ownerName, int balacne) {
			this.accountNo = accountNo;
			this.ownerName = ownerName;
			this.balance = balance;
		}
		
		public void deposit(int amount) { // ����: ����������� -> ���� -> �����İ��¹�ȣ���
			// Account a = new Account("11-11","ȫ")
			// a.deposit(10) -> ���⼭ this == a
			System.out.println("������: "+this);
			balance += amount; //// balance = balance + amount;
			System.out.println(amount+"�� ���� ��: "+this);
		}
		public void withdraw (int amount) throws Exception {
			
			if(balance < amount) { // �ܾ׺������� ���� ���ܹ߻� 
				throw new Exception(amount+"�� ����ϱ⿡�� �ܾ�("+balance+"��)�� �����մϴ�");
			}
			System.out.println("�����: "+this);
			balance -= amount; // balance = balance - amount;
			System.out.println(amount+"�� ��� ��: "+this);
		}
		@Override
		public String toString() {
			String result = "���¹�ȣ: "+accountNo+"\t ������: "+ownerName;
			result += "\t�ܾ�: "+balance; 	//// result = result + balance;
		return result;
		}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
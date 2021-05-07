package com.lec.ex6_account;

//Account acc = new Account();
//Runnable target1 = new ATM_card(acc);
//Runnable target2 = new ATM_card(acc);

public class ATM_card implements Runnable {
		
		private boolean flag = false;
		private Account obj;
		
		public ATM_card(Account obj) {
				this.obj = obj;
		}
		
		@Override
		public void run() {
				for(int i=0 ; i<10 ; i++) { // (10�� ���� ����� �ݺ�)
						if(flag) { 
								obj.withdraw(1000, Thread.currentThread().getName());
								flag = false; // (����� �ݺ��ϵ��� ����)
								
						} else { 
								obj.deposit(1000, Thread.currentThread().getName());
								flag = true;
						}
				}
		
		}
		
}
